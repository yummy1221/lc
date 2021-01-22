package leetcode;

import java.util.*;

public class Solution140 {
    // method 1: DFS  -  time exceed
    // method 2: DP
    public static List<String> wordBreak1(String s, Set<String> wordDict) {
        List<String> rst = new ArrayList<>();
        int len = s.length();
        List<List<String>> dp = new ArrayList<>();
        List<String> tmp;
        for(int i = 0; i < len; i++) {
            dp.add(new ArrayList<String>());
            tmp = dp.get(i);
            if(wordDict.contains(s.substring(0, i+1))) {
                tmp.add(s.substring(0, i+1));
            }
            for(int j = 0; j < i; j++) {
               if(wordDict.contains(s.substring(j+1, i+1))) {
                   for(String st : dp.get(j)) {
                       tmp.add(st+" "+s.substring(j+1, i+1));
                   }
               }
            }
        }
        return dp.get(len-1);
    }
    
    public static List<String> wordBreak(String s, Set<String> wordDict) {
    	int len = s.length();
        List<Integer> dp[] = new ArrayList[len];
        List<String> rst = new ArrayList<>();
        for(int i = len - 1; i >= 0; i--) {
            dp[i] = new ArrayList<Integer>();
        }
        for(int i = len - 1; i >= 0; i--) {
        	if(wordDict.contains(s.substring(i))) dp[i].add(len);
            for(String w : wordDict) {
            	if(i - w.length() < 0) {
            		continue;
            	}
            	if(!dp[i].isEmpty() && s.substring(i-w.length(),i).equals(w)) {
            		dp[i-w.length()].add(i);
            	}
            }
        }
        String t = "";
        System.out.println(dp[0]);
        if(!dp[0].isEmpty()) {
            //generate(s, dp, t, 0, rst);
        }
        return rst;
    }
    public static void generate(String s, List<Integer> []dp, String tmp, int begin, List<String> rst) {
        int len = s.length();
        if(begin > len) return;
        if(begin == len) {
            rst.add(tmp.substring(1));
            return;
        }
        for(int i : dp[begin]) {
            generate(s, dp, tmp+" "+s.substring(begin, i), i, rst);
        }
    }
    
    public static void main(String[] args) {
    	String[] s = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
    	String a = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    	Set<String> word = new HashSet<>(Arrays.asList(s));
    	System.out.println(wordBreak(a,word));
    }
}