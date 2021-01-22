package leetcode;

import java.util.*;
public class Solution131 {
	public static void main(String[]args) {
		String s = "aab";
		System.out.println(partition(s));
	}
	
	public static List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        partition(s, 0, rst, tmp);
        return rst;
    }
	
	private static void partition(String s, int start, List<List<String>> rst, List<String> tmp) {
        if(start >= s.length()) {
            rst.add(new ArrayList<String>(new ArrayList<String>(tmp)));
            return;
        }
        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s.substring(start, i+1))) {
                tmp.add(s.substring(start, i+1));
                partition(s, i + 1, rst, tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
	
	private static boolean isPalindrome(String s) {
        int len = s.length();
        if(len == 1) return true;
        int end = (len + 1) / 2;
        for(int i = 0; i < end; i++) {
            if(s.charAt(i) != s.charAt(len - i - 1)) return false;
        }
        return true;
    }
}
