package leetcode;
import java.util.*;
public class Solution32 {
	public static void main(String[]args) {
		Solution32 s = new Solution32();
		String str = "(()()(())((";
		int a = s.longestValidParentheses(str);
		System.out.println(a);
	}
	// corner case "()()"
	public int longestValidParentheses(String s) {
		int len = s.length();
        int max = 0;
        Stack<Integer> left = new Stack<>();
        int tmp = 0;
        int[] dp = new int[len];
        for(int i = 0; i < len; i++) {
            dp[i] = -1;
            if(s.charAt(i) == '(') {
                left.push(i);
            } else {
                if(!left.empty()) {
                    tmp = left.pop();
                    if(tmp != 0 && dp[tmp-1] >= 0) tmp = dp[tmp-1];
                    if(i - tmp + 1 > max) max = i - tmp + 1;
                    dp[i] = tmp;
                }
            }
        }
        for(int i = 0; i < len; i++) {
        	System.out.println(i+" "+dp[i]);
        }
        return max;
    }
}
