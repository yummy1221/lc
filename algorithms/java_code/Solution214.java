package leetcode;

public class Solution214 {
	public static void main(String[]args) {
		Solution214 s = new Solution214();
		String a = "aaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(s.shortestPalindrome(a));
	}
	public String shortestPalindrome(String s) {
        int len = s.length();
        int x = 0, y = 0;
        int i = 0;
        boolean b = false;
        for(i = len - 1; i >= 0; i--) {
            System.out.println("1");
            x = 0; y = i;
            b = false;
            while(x < y) {
                if(s.charAt(x) != s.charAt(y)) {
                    b = true;
                    break;
                }
                x++; y--;
            }
            if(!b) break;
        }
        String head = s.substring(i+1, len);
        s = new StringBuilder(head).reverse().toString() + s;
        return s;
    }
}
