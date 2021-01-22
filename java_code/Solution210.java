package leetcode;

import java.util.*;

public class Solution210 {
	public static void main(String[]args) {
		int[][] prerequisites = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		int[] rst = findOrder(10, prerequisites);
		System.out.println(rst);
		for(int i = 0; i < rst.length; i++)
			System.out.println(rst[i]);
	}
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] rst = new int[numCourses];
        HashSet<Integer>[] graph = (HashSet<Integer>[]) new HashSet[numCourses];
        HashMap<Integer, Integer> in_degree = new HashMap<>();
        Set<Integer> courses = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<Integer>();
            courses.add(i);
        }
        int len = prerequisites.length;
        // initialize
        for(int i = 0; i < len; i++) {
            if(!graph[prerequisites[i][1]].contains(prerequisites[i][0])) {
                graph[prerequisites[i][1]].add(prerequisites[i][0]);
                if(in_degree.containsKey(prerequisites[i][0])) {
                    in_degree.put(prerequisites[i][0], in_degree.get(prerequisites[i][0]) + 1);
                } else {
                    in_degree.put(prerequisites[i][0], 1);
                }    
            }
        }
        int count = 0;
        while(in_degree.size() != courses.size()) {
            for(int i : courses) {
                // input degree == 0
                if(!in_degree.containsKey(i)) {
                    courses.remove(i);
                    rst[count++] = i;
                    for(int j : graph[i]) {
                        if(in_degree.get(j) == 1) {
                            in_degree.remove(j);
                        } else {
                            in_degree.put(j, in_degree.get(j) - 1);
                        }
                    }
                    break;
                }
            }
        }
        if(!courses.isEmpty()) return null;
        return rst;
    }
}
