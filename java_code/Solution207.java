package leetcode;

import java.util.*;
public class Solution207 {
	public static void main(String[]args) {
		int[][] prerequisites = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		System.out.println(canFinish(10, prerequisites));
	}
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
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
        
        // topological sort
        boolean b = true;
        while(in_degree.size() != courses.size()) {
        	System.out.println(courses);
        	System.out.println(in_degree);
            for(int i : courses) {
                // input degree == 0
                if(!in_degree.containsKey(i)) {
                    courses.remove(i);
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
        return courses.isEmpty();
    }
}
