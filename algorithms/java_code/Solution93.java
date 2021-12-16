package leetcode;
import java.util.*;
public class Solution93 {
	public static List<String> restoreIpAddresses(String s) {
        String max = "256";
        StringBuilder tmp = new StringBuilder();
        List<String> rst = new ArrayList<>();
        int len = s.length();
        int s1 = 0, s2 = 0, s3 = 0, s4 = 0;
        for(s2 = s1 + 1; s2 <= s1 + 3; s2++) {
        	if(s2 > len - 1 || (s.charAt(s1) == '0' && s2 - s1 > 1)) break;
            if(s2 + 9 < len) continue;
            if(s2 - s1 < 3 || s.substring(s1,s2).compareTo(max) < 0) {
                tmp.append(s.substring(s1,s2));
                tmp.append('.');
            } else {
                continue;
            }
            for(s3 = s2 + 1; s3 <= s2 + 3; s3++) {
            	if(s3 > len - 1 || (s.charAt(s2) == '0' && s3 - s2 > 1)) break;
                if(s3 + 6 < len) continue;
                if(s3 - s2 < 3 || s.substring(s2,s3).compareTo(max) < 0) {
                    tmp.append(s.substring(s2,s3));
                    tmp.append('.');
                } else {
                    continue;
                }
                for(s4 = s3 + 1; s4 <= s3 + 3; s4++) {
                	if(s4 > len - 1 || (s.charAt(s3) == '0' && s4 - s3 > 1)) break;
                    if(s4 + 3 < len || (s.charAt(s4) == '0' && len - s4 > 1)) continue;
                    if((s4 - s3 < 3 || s.substring(s3,s4).compareTo(max) < 0) && (len - s4 < 3 || s.substring(s4, len).compareTo(max) < 0)) {
                        tmp.append(s.substring(s3,s4));
                        tmp.append('.');
                        tmp.append(s.substring(s4,len));
                        rst.add(tmp.toString());
                    } else {
                        continue;
                    }
                    tmp.delete(s3+2, tmp.length());
                }
                tmp.delete(s2+1, tmp.length());
            }
            tmp.delete(s1, tmp.length());
        }
        return rst;
    }
	public static void main(String[]args) {
		String tmp = "101023";
		List<String> a = restoreIpAddresses(tmp);
		for(String s : a)
			System.out.println(s);
	}
}
