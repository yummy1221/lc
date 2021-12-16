package leetcode;

import java.util.*;
public class Solution139 {
	public static boolean wordBreak(String s, Set<String> wordDict) {
        return word(s, wordDict, 0);
    }
    
    public static boolean word(String s, Set<String> wordDict, int begin) {
        if(wordDict.contains(s.substring(begin))) return true;
        int len = s.length();
        if(begin == len - 1) return false;
        for(int i = begin+1; i < len; i++) {
            if(wordDict.contains(s.substring(begin, i)) && word(s, wordDict, i))
                return true;
        }
        return false;
    }
    
    public static boolean wordBreak2(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] b = new boolean[len];
        for(int i = 0; i < len; i++) {
        	if(wordDict.contains(s.substring(0, i+1)))
                b[i] = true;
            else
                b[i] = false;
            for(int j = 0; j < i; j++) {
                if(b[j] && wordDict.contains(s.substring(j+1, i+1))) {
                    b[i] = true;
                    break;
                }
            }
        }
        return b[len-1];
    }
    public static void main(String[]args) {
    	String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    	String[] s = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
    	Set<String> word = new HashSet<>(Arrays.asList(s));
    	System.out.println(wordBreak2(a,word));
    }
}
