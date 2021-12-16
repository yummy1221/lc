package leetcode;

import java.util.*;
public class Solution90 {
	
	public static void main(String[]args) {
		int[] nums = {4,1,0}; 
		System.out.println(subsetsWithDup(nums));
	}
	
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        subsets(rst, tmp, nums, 0);
        return rst;
    }
    
    private static void subsets(List<List<Integer>> rst, ArrayList<Integer> tmp, int[] nums, int start) {
        int len = nums.length;
        if(start >= len) {
            rst.add(new ArrayList<Integer>(tmp));
            return;
        }
        int s = nums[start];
        int count = 0;
        int i = 0;
        for(i = start; i < len; i++) {
            if(nums[i] != s) {
                break;
            }
            count++;
        }
        int size = tmp.size();
        subsets(rst, tmp, nums, i);
        for(int j = 0; j < count; j++) {
            tmp.add(s);
            subsets(rst, tmp, nums, i);
        }
        for(i = 0; i < count; i++)
            tmp.remove(tmp.size()-1);
    }
}