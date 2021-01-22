package leetcode;

import java.util.*;

public class Solution291 {
	public static void main(String[]args) {
		String pattern = "ab";
		String str = "aabb";
		System.out.println(wordPatternMatch(pattern, str));
	}
	
    public static boolean wordPatternMatch(String pattern, String str) {
        String[] map = new String[26];
        HashSet<String> set = new HashSet<>();
        return wordPatternMatch(pattern, 0, str, 0, map, set);
    }
    
    private static boolean wordPatternMatch(String pattern, int i_pattern, String str, int i_str, String[] map, HashSet<String> set) {
        if(i_pattern == pattern.length()) {
            if(i_str == str.length())
                return true;
            else
                return false;
        }
        if(i_str >= str.length()) return false;
        int index = pattern.charAt(i_pattern) - 'a';
        int len = 0;
        if(map[index] != null) {
            len = map[index].length();
            if(len + i_str > str.length()) {
                return false;
            } else if (!str.substring(i_str, i_str+len).equals(map[index])) {
                return false;
            } else {
                return wordPatternMatch(pattern, i_pattern + 1, str, i_str+len, map, set);
            }
        } else {
            String sub;
            for(int i = i_str + 1; i <= str.length(); i++) {
                sub = str.substring(i_str, i);
                if(set.contains(sub)) continue;
                map[index] = sub;
                set.add(sub);
                if(wordPatternMatch(pattern, i_pattern + 1, str, i, map, set)) {
                    return true;
                }
                map[index] = null;
                set.remove(sub);
            }
        }
        return false;
    }
}
