package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution271 {
	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length());
            sb.append(' ');
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int tmp = 0;
        int len = s.length();
        int i = 0;
        List<String> rst = new ArrayList<>();
        while(i < len) {
        	tmp = 0;
            while(s.charAt(i) != ' ') {
                tmp = tmp * 10 + s.charAt(i++) - '0';
            }
            i++;
            rst.add(s.substring(i, i+tmp));
            i = i + tmp;
        }
        return rst;
    }
    
    public static void main(String[]args) {
    	List<String> strs = new ArrayList<>();
    	strs.add("hello");
    	strs.add("world");
    	Solution271 s = new Solution271();
    	System.out.println(s.decode(s.encode(strs)));
    }
}
