import java.util.Arrays;

public class Solution3 {
	
	public static String getPermutation(int n, int k) {
        int[] arr = new int[n];
        char[] result = new char[n];
        int index = k, div = 1;
        int tmp = 0;
        for(int i = 1; i < n; i++) {
            arr[i-1] = i;
            div = div * i;
        }
        arr[n-1] = n;
        for(int i = 0; i < n-1; i++) {
            Arrays.sort(arr, 0, n-i);
            tmp = (index - 1) / div;
            result[i] = (char)('0' + arr[tmp]);
            System.out.println(i+" "+result[i]);
            index = index - tmp * div;
            div = div / (n - i - 1);
            arr[tmp] = arr[n-i-1];
         }
         result[n-1] = (char)('0' + arr[0]);
        return new String(result);
    }

	public static void main(String[]args) {
		System.out.println(getPermutation(10,8));
	}
}
