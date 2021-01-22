package leetcode;

public class Solution309 {
	public static int maxProfit(int[] prices) {
		int len = prices.length;
        int res = 0;
        int previous = 0;
        int low_index = 0;
        for(int i = 0; i < len; i++) {
        	//System.out.println(i);
            low_index = i;
            while(i+1 < len && prices[i] >= prices[i+1]) i++;
            if(i + 1 == len) break;
            //System.out.println(i);
            if(i == low_index && i != 0) {
            	//System.out.println(i);
                res = res - Math.min(previous, prices[i+1] - prices[i]);
            }
            low_index = i;
            while(i+1 < len && prices[i] <= prices[i+1]) i++;
            res = res + prices[i] - prices[low_index];
            previous = prices[i] - prices[i-1];
            System.out.println(res);
        }
        return res;
    }
	
	public static void main(String[]args) {
		int[] a = {1,6,2, 8, 3, 19, 2};
		System.out.println(maxProfit(a));
	}
}
