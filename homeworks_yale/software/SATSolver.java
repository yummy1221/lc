package software;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.Iterator;

public class SATSolver {
	/**
	 *  private fields
	 */
	private int variables;
	private int clauses;
	private int[][] cnf;
	private int[][] level;
	private Set<Integer>[] unassigned;
	// 0 - unassigend, 1 - guessed, 2 - guessed both way
	// -1 - deduced
	private int[] solution;		
	private Stack<Integer> stack = new Stack<Integer>();
	private PriorityQueue<Integer> decisions;
	
	/**
	 * public function, interface with outside world
	 * print out the result
	 * @throws FileNotFoundException
	 */
	public void satSolver(String filename) throws FileNotFoundException {
		initialize(filename);
		if(!sat()) {
			System.out.println("s UNSATISFIABLE");
		} else {
			System.out.println("s SATISFIABLE");
			System.out.print("v ");
			print();
		}
	}
	
	private void assign(int x) {
		int index = Math.abs(x) - 1;
		int len = stack.size();
		stack.push(x);
		int p = (x > 0) ? 1 : -1;
		if(decisions.peek() == index)
			decisions.poll();
		// decisions.remove(index);
		// used for unit propagation
		// when level = 1, time to deduce, when level = 0, conflict found
		for(int i = 0; i < clauses; i++) {
			if(cnf[i][index] * p == -1) {
				level[i][len+1] = level[i][len] - 1; 
			} else {
				level[i][len+1] = level[i][len];
			}
			if(cnf[i][index] != 0) {
				unassigned[i].remove(index);
			}
		}
	}
	
	private int remove() {
		int tmp = stack.pop();
		int index = Math.abs(tmp) - 1;
		decisions.add(index);
		for(int i = 0; i < clauses; i++) {
			if(cnf[i][index] != 0) {
				unassigned[i].add(index);
			}
		}
		return tmp;
	}
	/**
	 * initialization method, read input, initialize fields
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private void initialize(String filename) throws FileNotFoundException {
		File text = new File(filename);
		Scanner s = new Scanner(text);
		s.next(); s.next();
		variables = s.nextInt();
		clauses = s.nextInt();
		cnf = new int[clauses][variables];
		unassigned = new HashSet[clauses];
		level = new int[clauses][variables+1];
		solution = new int[variables];
		int tmp = 0;
		final HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i = 0; i < variables; i++) {
			hm.put(i, 0);
		}
		int index = 0;
		for(int i = 0; i < clauses; i++) {
			unassigned[i] = new HashSet<Integer>();
			tmp = Integer.parseInt(s.next());
					//s.nextInt();
			while(tmp != 0) {
				index = Math.abs(tmp)-1;
				unassigned[i].add(index);
				hm.put(index, hm.get(index)+1);
				cnf[i][index] = (tmp > 0) ? 1 : -1;
				tmp = s.nextInt();
			}
		}
		s.close();
		decisions = new PriorityQueue<Integer>(100, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return hm.get(o2) - hm.get(o1);
			}
		});
		for(int i = 0; i < variables; i++) {
			decisions.add(i);
		}
		int count = 0;
		for(int i = 0; i < clauses; i++) {
			count = 0;
			for(int j = 0; j < variables; j++) {
				count += Math.abs(cnf[i][j]);
			}
			level[i][0] = count;
		}
	}
	
	/**
	 * core function for processing CNF input
	 * @return if the CNF is satisfiable
	 */
	private boolean sat() {
		Scanner s = new Scanner(System.in);
		// core code
		while(true) {
			//s.nextLine();
			if(!decide())		// guess a value
				return true;
			while(!bcp()) {		// deduce all possible values
				if(!resolveConflict()) {
					return false;
				}
			}
		}
	}
	
	/**
	 * dealing with unit propogation
	 * deduce the value
	 * @return
	 */
	private boolean bcp() { // deduce values
		int len = stack.size();
		int var = 0;
		for(int i = 0; i < clauses; i++) {
			if(level[i][len] == 1 && unassigned[i].size() > 0) {	// find unit
				if(unassigned[i].iterator().hasNext()) {
					int j = unassigned[i].iterator().next();
					solution[j] = -1;
					assign((j+1)*cnf[i][j]);
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * decide whether the CNF now is conflict or not
	 * if conflict, try to resolve it or return false
	 * @return
	 */
	public boolean resolveConflict() {
		int len = stack.size();
		int tmp = 0;
		for(int i = 0; i < clauses; i++) {
			if(level[i][len] == 0) {	// a conflict occurs
				tmp = remove();
				while(solution[Math.abs(tmp)-1] != 1) {
					solution[Math.abs(tmp)-1] = 0;
					if(stack.isEmpty())		// this conflict cannot be resolved
						return false;
					tmp = remove();				
				}
				solution[Math.abs(tmp)-1] = 2;
				assign(tmp*(-1));
				return true;		// conflict resolved
			}
		}
		return true;		// no conflict exists
	}
	
	/**
	 * guess the value of a variable
	 * @return
	 */
	public boolean decide() {	// guess a value
		int len = stack.size();
		if(len == variables) return false;
		int i = decisions.peek();
		//decisions.peek();
		while(solution[i] != 0) {
			decisions.poll();
			i = decisions.peek();
		}
		solution[i] = 1;
		assign(i+1);
		return true;
	}
	
	/**
	 * print the result
	 */
	private void print() {
		int[] rst = new int[variables];
		int tmp = 0;
		while(!stack.isEmpty()) {
			tmp = stack.pop();
			rst[Math.abs(tmp)-1] = tmp;
		}
		for(int i = 0; i < variables; i++) {
			if(i % 10 == 0)
				System.out.println();
			System.out.print(rst[i]+" ");
		}
		System.out.println();
	}
}
