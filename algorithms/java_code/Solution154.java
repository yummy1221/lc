package leetcode;

import java.util.*;

public class Solution154 {
	public static int findMin(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int mid = 0;
        while(left < right) {
        	if(nums[left] == nums[right]) {
        		left++;
        		continue;
        	}
            System.out.println(left+" "+right);
            if(nums[left] < nums[right])    return nums[left];
            mid = (left + right) / 2;
            if(nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
	
	public static void main(String[]args) {
		int[] a = {1,1,2,3,4,5,5,0,1};
		System.out.println(findMin(a));
		int c = (int)Math.pow(2, 2);
		List<Integer> lst = new ArrayList<>();
		lst.add(2);
		lst.add(3);
		lst.add(4);
		lst.add(5);
		List<List<Integer>> l = new ArrayList<>();
		l.add(lst);
		int x = 10;
		
		System.out.println(1 << 1);
	}
}
