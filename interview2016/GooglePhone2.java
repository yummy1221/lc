package jobs;
import java.util.*;
//1/5/2015
//First Phone Question
public class GooglePhone2 {

	// my stupid brute force method, which I implemented during phone interview
	/**
	 * total number of values in matrix : N
	 * time : O(N log K)
	 * space : O(K)
	 */
	List<Integer> findKSmallest(int[][] matrix, int k) {
		// Max heap by using reverse()
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		LinkedList<Integer> rst = new LinkedList<>();
		int row = matrix.length;
		if(row == 0) return rst;
		int column = matrix[0].length;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				if(pq.size() < k) {
					pq.add(matrix[i][j]);
				} else {
					if(pq.peek() > matrix[i][j]) {
						pq.poll();
						pq.add(matrix[i][j]);
					}
				}
			}
		}
		while(!pq.isEmpty()) {
			rst.addFirst(pq.poll());
		}
		return rst;
	}
	
	public static void main(String[]args) {
		GooglePhone2 g = new GooglePhone2();
		int[][] matrix = {
				{1,10,20,30,40,50}, 
				{5,15,35,38,56,58},
				{8,25,45,48,60,65}};
		long startTime = System.currentTimeMillis();
		List<Integer> lst = g.findKSmallest(matrix, 10);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime+"ms");
		System.out.println(totalTime/1000+"s");
		for(Integer i : lst)
			System.out.print(i + " ");
		System.out.println();
		startTime = System.currentTimeMillis();
		lst = g.findKSmallest2(matrix, 10);
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println(totalTime+"ms");
		System.out.println(totalTime/1000+"s");
		for(Integer i : lst)
			System.out.print(i + " ");
		System.out.println();
	}
	
	// another method
	/** ? 
	 * total number of values in matrix : N
	 * time : O(K)
	 * space : O(column)
	 */
	class Element {
		int value;
		int row;
		int column;
		public Element(int v, int r, int c) {
			value = v;
			row = r;
			column = c;
		}
	}
	List<Integer> findKSmallest2(int[][] matrix, int k) {
		List<Integer> rst = new ArrayList<>();
		int row = matrix.length;
		if(row == 0) return rst;
		int column = matrix[0].length;
		PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){

			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				return o1.value - o2.value;
			}
			
		});
		for(int i = 0; i < column; i++) {
			pq.add(new Element(matrix[0][i], 0, i));
		}
		Element tmp;
		while(rst.size() < k && !pq.isEmpty()) {
			tmp = pq.poll();
			rst.add(tmp.value);
			if(tmp.row < row - 1) {
				pq.add(new Element(matrix[tmp.row+1][tmp.column], tmp.row + 1, tmp.column));
			}
		}
		return rst;
	} 
}
