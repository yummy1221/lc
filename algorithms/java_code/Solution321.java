package leetcode;

import java.util.*;
public class Solution321 {
	public static void main(String[]args) {
		int[] nums1 = {1,6,5,4,7,3,9,5,3,7,8,4,1,1,4}; 
		int[] nums2 = {4,3,1,3,5,9};
		Solution321 s = new Solution321();
		int k = 21;
		//int[] rst = s.maxNumber(nums1, nums2, k);
		int[] rst = s.merge(nums1, nums2);
		for(int i = 0; i < rst.length; i++)
			System.out.print(rst[i]);
	}
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int l1 = nums1.length;
    	int l2 = nums2.length;
    	int[] rst = new int[k];
    	int[] tmp = new int[k];
    	int s = 0, e = k;
    	if(l1 < k) {
    		e = l1;
    	}
    	if(l2 < k) {
    		s = k - l2;
    	}
    	for(int i = s; i <= e; i++) {
    		System.out.println(i);
    		tmp = merge(findMax(nums1, i), findMax(nums2, k - i));
    		if(greater(tmp, rst)) rst = tmp;
    	}
        return rst;
    }
    public boolean greater(int[] nums1, int[] nums2) {
    	int len = nums1.length;
    	for(int i = 0; i < len; i++) {
    		if(nums1[i] > nums2[i])
    			return true;
    		else if(nums1[i] < nums2[i])
    			return false;
    	}
    	return false;
    }
    public int[] findMax(int[] nums, int k) {
    	Stack<Integer> stack = new Stack<>();
    	int len = nums.length;
    	if(k >= len) return nums.clone();
    	int[] rst = new int[k];
    	for(int i = 0; i < len; i++) {
    		if(stack.size() == 0 || stack.peek() >= nums[i]) {
    			stack.push(nums[i]);
    		} else {
    			while(!stack.empty() && stack.peek() < nums[i] && (stack.size() + len - i) > k)
    				stack.pop();
    			stack.push(nums[i]);
    		}
    	}
    	while(stack.size() > k) stack.pop();
    	for(int i = k - 1; i >= 0; i--) {
    		rst[i] = stack.pop();
    	}
    	return rst;
    }
    
    public int[] merge(int[] nums1, int[] nums2) {
    	int l1 = nums1.length;
    	int l2 = nums2.length;
    	int[] rst = new int[l1+l2];
    	int i1 = 0, i2 = 0, i = 0;
    	int tmp1 = 0, tmp2 = 0;
    	while(i1 < l1 && i2 < l2) {
    		if(nums1[i1] > nums2[i2]) {
    			rst[i++] = nums1[i1++];
    		} else if(nums1[i1] < nums2[i2]) {
    			rst[i++] = nums2[i2++];
    		} else {
    			tmp1 = i1;
    			tmp2 = i2;
    			while(tmp1 < l1 && tmp2 < l2 && nums1[tmp1] == nums2[tmp2]) {
    				tmp1++; tmp2++;
    			}
    			if(tmp2 == l2 || (tmp1 < l1 && nums1[tmp1] > nums2[tmp2])) {
    				rst[i++] = nums1[i1++];
    			} else {
    				rst[i++] = nums2[i2++];
    			}
    		}
    		//System.out.println(rst[i-1]);
    	}
    	while(i1 < l1)
    		rst[i++] = nums1[i1++];
    	while(i2 < l2)
    		rst[i++] = nums2[i2++];
    	return rst;
    }
}