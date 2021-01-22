package leetcode;

public class Solution67 {
	public static void main(String[]args) {
		Solution67 s = new Solution67();
		String a = "11", b = "111";
		System.out.println(s.addBinary(a, b));
	}
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i1 = a.length() - 1;
        int i2 = b.length() - 1;
        int low = 0;
        int add = 0;
        while(i1 >= 0 && i2 >= 0) {
            add = (a.charAt(i1--) & 1) + (b.charAt(i2--) & 1) + (low & 1);
            sb.append(add & 1);
            low = add >> 1;
        }
        while(i2 >= 0) {
            add = (b.charAt(i2--) & 1) + (low & 1);
            sb.append(add & 1);
            low = add >> 1;
        }
        while(i1 >= 0) {
            add = (a.charAt(i1--) & 1) + (low & 1);
            sb.append(add & 1);
            low = add >> 1;
        }
        if(low == 1) sb.append(low);
        sb.reverse();
        return sb.toString();
    }
}
