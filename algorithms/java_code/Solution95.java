package leetcode;

import java.util.*;
public class Solution95 {
	public static void main(String[]args) {
		Solution95 s = new Solution95();
		List<TreeNode> lst = s.generateTrees(0);
		System.out.println(lst.size());
	}
	public List<TreeNode> generateTrees(int n) {
		if(n == 0) return new ArrayList<TreeNode>();
		ArrayList<TreeNode>[][] dp = (ArrayList<TreeNode>[][])new ArrayList[n][n];
		TreeNode t;
        for(int i = n-1; i >= 0; i--) {
        	for(int j = i; j < n; j++) {
        		dp[i][j] = new ArrayList<TreeNode>();
        		if(i == j) {
        			dp[i][j].add(new TreeNode(i+1));
        		} else if(i + 1 == j){
        			t = new TreeNode(i+1);
        			t.right = dp[j][j].get(0);
        			dp[i][j].add(t);
        			t = new TreeNode(j+1);
        			t.left = dp[i][i].get(0);
        			dp[i][j].add(t);
        		} else {
        			for(TreeNode t3 : dp[i+1][j]) {
    					t = new TreeNode(i+1);
    					t.right = t3;
    					dp[i][j].add(t);
    				}
        			for(int k = i + 1; k < j; k++) {
        				for(TreeNode t1 : dp[i][k-1]) {
        					for(TreeNode t2 : dp[k+1][j]) {
        						t = new TreeNode(k+1);
        						t.left = t1;
        						t.right = t2;
        						dp[i][j].add(t);
        					}
        				}
        			}
        			for(TreeNode t3 : dp[i][j-1]) {
    					t = new TreeNode(j+1);
    					t.left = t3;
    					dp[i][j].add(t);
    				}
        		}
        	}
        }
        return dp[0][n-1];
    }
}
