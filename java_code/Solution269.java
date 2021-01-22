package leetcode;

import java.util.*;

public class Solution269 {
	public static void main(String[]args) {
		String[] words = {"tacfeiea",
				"t",
				"ugwchsual",
				"gt",
				"ozlqu"
				};
		System.out.println(alienOrder(words));
	}
	
	private static void constructGraph(String[] words, Set<Integer>[] graph, int s, int e, int index, Set<Character> hs) {
		if(s > e) return;
		if(index >= words[s].length()) return;
		char previous = words[s].charAt(index);
		hs.add(previous);
		int i = s;
		int tmp = 0;
		int end = 0;
		while(i <= e) {
			if(index >= words[i].length()) return;
			if(previous != words[i].charAt(index)) {
				graph[previous - 'a'].add((int)(words[i].charAt(index)-'a'));
				previous = words[i].charAt(index);
				hs.add(previous);
			}
			tmp = i;
			end = i;
			while(i <= e && words[i].charAt(index) == previous) {
				if(words[i].length() > index + 1) end++;
				i++;
			}
			if(tmp < end) {
				constructGraph(words, graph, tmp, end - 1, index + 1, hs);
			}
		}
	}
    public static String alienOrder(String[] words) {
        // initialize graph
        int len = words.length;
        Set<Character> hs = new HashSet<>();
        Set<Integer>[] graph = (Set<Integer>[])new Set[26];
        for(int i = 0; i < 26; i++)
            graph[i] = new HashSet<Integer>();
        constructGraph(words, graph, 0, len - 1, 0, hs);
//        for(int i = 0; i < 26; i++) 
//        	System.out.println(i+" " + (char)(i+'a') +" "+graph[i]);
        // begin topological sort
        boolean[] marked = new boolean[26];
        boolean[] onStack = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < 26; i++) {
            if(!marked[i] && !dfs(marked, onStack, graph, i, stack, hs))
                return "";
        }
        char[] rst = new char[stack.size()];
        for(int i = 0; i < rst.length; i++) {
            rst[i] = stack.pop();
        }
        return new String(rst);
    }
    
    private static boolean dfs(boolean[] marked, boolean[] onStack, Set<Integer>[] graph, int v, Stack<Character> stack, Set<Character> hs) {
        onStack[v] = true;
        marked[v] = true;
        int count = 0;
        for(int i : graph[v]) {
            if(!marked[i] && !dfs(marked, onStack, graph, i, stack, hs)) {
                return false;
            } else if(marked[i] && onStack[i]) {
                return false;
            } else if(marked[i]) {
                count++;
            }
        }
        if(count == graph[v].size() && hs.contains((char)(v + 'a'))) {
            stack.push((char)(v + 'a'));
        }
        onStack[v] = false;
        return true;
    }
}
