package leetcode;

import java.util.*;

public class Solution132 {
	public static void main(String[]args) {
		Solution132 solution = new Solution132();
		String a = "aaaaaaaabaaaaaaaaaaaaaa";
		System.out.println(solution.minCut(a));
	}
	
    public int minCut(String s) {
        int len = s.length();
        boolean[][] palinrome = new boolean[len][len];
        int[] dp = new int[len];
        for(int i = len - 1; i >= 0; i--) {
        	palinrome[i][i] = true;
        	for(int j = i+1; j < len; j++) {
        		if(s.charAt(i) == s.charAt(j)) {
        			if(i + 1 == j || palinrome[i+1][j-1])
        				palinrome[i][j] = true;
        		}
        	}
        }
        
        for(int i = len - 1; i >= 0; i--) {
        	
            int min = s.length();
            if(palinrome[i][len-1]) {
                dp[i] = 0;
            } else {
                for(int j = i+1; j < len; j++) {
                    if(palinrome[i][j-1] && min > dp[j] + 1)
                        min = dp[j] + 1;
                }
                dp[i] = min;
            }
        }
        return dp[0];
    }

}
