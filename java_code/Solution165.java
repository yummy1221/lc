package leetcode;

public class Solution165 {
	
	public static int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int la = a.length;
        int lb = b.length;
        int len = Math.max(la, lb);
        int va = 0, vb = 0;
        System.out.println(len);
        for(int i = 0; i < len; i++) {
            va = vb = 0;
            if(i < la)
                va = Integer.parseInt(a[i]);
            if(i < lb)
                vb = Integer.parseInt(b[i]);
            System.out.println(va+" "+vb);
            if(va > vb)
                return 1;
            else if(va < vb)
                return -1;
        }
        return 0;
    }
	public static void main(String[]args) {
		String version1 = "0";
		String version2 = "1";
		
        System.out.println(compareVersion(version1, version2));
	}
}
