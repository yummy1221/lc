package leetcode;

import java.util.*;

public class Solution267 {
	public static void main(String[]args) {
		List<String> a = generatePalindromes("aabb");
		System.out.println(a);
	}
    public static List<String> generatePalindromes(String s) {
        List<String> rst = new ArrayList<>();
        int len = s.length();
        int[] map = new int[256];
        char a = ' ';
        for(int i = 0; i < len; i++) {
            a = s.charAt(i);
            map[a] += 1;
        }
        boolean b = true;
        char[] chars = new char[(len + 1) / 2];
        int count = 0;
        for(int i = 0; i < 256; i++) {
            if(map[i] % 2 == 1) {
                for(int j = 0; j < map[i] / 2 + 1; j++)
                    chars[count++] = (char)i;
                if(b) b = false;
                else return rst;
            } else {
                for(int j = 0; j < map[i] / 2; j++)
                    chars[count++] = (char)i;
            }
        }
        // generate rst using recursive
        char[] buff = new char[len];
        boolean[] used = new boolean[chars.length];
        generatePalindromes(buff, rst, chars, used, 0);
        return rst;
    }
    
    private static void generatePalindromes(char[] buff, List<String> rst, char[] chars, boolean[] used, int index) {
        if(index >= (buff.length + 1) / 2) {
            for(int i = buff.length - 1; i >= (buff.length + 1) / 2; i--) {
                buff[i] = buff[buff.length - 1 - i];
            }
            rst.add(new String(buff));
            return;
        }
        for(int i = 0; i < used.length; i++) {
            if(used[i]) continue;
            if(i > 0 && chars[i] == chars[i-1] && used[i-1] == false) continue; 
            buff[index] = chars[i];
            used[i] = true;
            generatePalindromes(buff, rst, chars, used, index + 1);
            used[i] = false;
        }
    }
}