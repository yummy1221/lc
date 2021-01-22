package leetcode;

public class Solution162 {
	public static void main(String[]args) {
		int[] nums = {4,5,8,3,2,1};
		System.out.println(findPeakElement3(nums));
	}
	public static int findPeakElement3(int[] nums) {
		int len = nums.length;
		if(len == 1) return 0;
		int left = 0, right = len - 1;
		int mid = 0;
		while(left < right) {
			mid = (left + right) / 2;
			if(nums[mid] > nums[mid+1]) {
				right = mid;
			} else {
			    left = mid + 1;
			}
		}
		return left;
	}
	public static int findPeakElement2(int[] nums) {
		int len = nums.length;
		if(len == 1) return 0;
		int left = 0, right = len - 1;
		int mid = 0;
		while(left <= right) {
			mid = (left + right) / 2;
			if(mid == 0 && nums[mid] > nums[mid+1]) return mid;
			if(mid == len - 1 && nums[mid] > nums[mid-1]) return mid;
			if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) return mid;
			if(mid == 0) {
				left = mid + 1;
			} else if(mid == len - 1) {
				right = mid - 1;
			} else if(nums[mid] < nums[mid-1]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
	public static int findPeakElement(int[] nums) {
		int len = nums.length;
		if(len == 1) return 0;
		return binarySearch(nums, 0, len-1);
    }
	
	private static int binarySearch(int[] nums, int left, int right) {
		if(left > right) return -1;
		int mid = (left + right) / 2;
		//System.out.println(mid);
		int len = nums.length;
		if(left < 0 || right >= len) return -1;
		if(mid - 1 < 0 && nums[mid + 1] < nums[mid]) return mid;
		if(mid + 1 == len && nums[mid - 1] < nums[mid]) return mid;
		if(mid - 1 >= 0 && mid + 1 < len && nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
			return mid;
		} else {
			int tmp = binarySearch(nums, left, mid-1);
			if(tmp >= 0) return tmp;
			tmp = binarySearch(nums, mid+1, right);
			if(tmp >= 0) return tmp;
		}
		return -1;
	}
}
