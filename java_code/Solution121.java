package leetcode;

public class Solution121 {
	public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        int profit = 0;
        int max, min;
        max = min = prices[0];
        for(int i = 0; i < len; i++) {
            if(min > prices[i]) {
            	min = prices[i];
            	max = min;
            }
            if(max < prices[i]) {
            	max = prices[i];
            	if(profit < max - min)
            		profit = max - min;
            }
        }
        return profit;
    }
	
	public static void main(String[]args) {
		int[] a = {4,1,2};
		System.out.println("Max Profit: " + maxProfit(a));
	}
}
