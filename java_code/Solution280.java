package leetcode;

import java.util.*;
public class Solution280 {
	public static void main(String[]args) {
		Solution280 a = new Solution280();
		int[] nums = {1,2,2,1,2,1,1,1,1,2,2,2};
		a.wiggleSort(nums);
		System.out.println(1 & 10);
		for(int i = 0; i < nums.length; i++)
			System.out.println(nums[i]);
	}
	public void wiggleSort(int[] nums) {
		int len = nums.length;
        int tmp = 0;
        for(int i = 1; i < len; i++) {
            if(((i & 1) == 1 && nums[i] <= nums[i-1]) || ((i & 1) == 0 && nums[i] >= nums[i-1])) {
                tmp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = tmp;
            }
                
        }
    }
}
