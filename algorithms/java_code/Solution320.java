package leetcode;
import java.util.*;
public class Solution320 {
	// How to do with bit manipulation???????
	// ??????
	public static void main(String[]args) {
		Solution320 s = new Solution320();
		String str = "hello word~";
		List<String> rst = s.generateAbbreviations(str);
		//Collections.sort(rst);
		for(int i = 0; i < rst.size(); i++) 
			System.out.print(rst.get(i) + ", ");
		StringBuilder s1 = new StringBuilder();
		System.out.println();
		System.out.println(rst.size());
		String a = "abc";
	}
	public List<String> generateAbbreviations(String word) {
		List<String> rst = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
        char[] c = word.toCharArray();
        generateAbbreviations(c, 0, rst, sb);
        return rst;
    }
	private void generateAbbreviations(char[] arr, int s, List<String> rst, StringBuilder sb) {
		int len = arr.length;
		if(s == len) {
			rst.add(sb.toString());
			return;
		}
		int tmp = 0;
		for(int i = s; i < len; i++) {
			tmp = sb.length();
			if(i != s) {
				sb.append(i - s);
			}
			sb.append(arr[i]);
			generateAbbreviations(arr, i+1, rst, sb);
			sb.delete(tmp, sb.length());
		}
		tmp = sb.length();
		sb.append(len - s);
		rst.add(sb.toString());
		sb.delete(tmp, sb.length());
	}
}
