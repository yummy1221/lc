import java.util.*;

// LeetCode 259: 3Sum Smaller - Medium Locked
public class Solution259 {
	public static int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        int m = 0, n = 0;
        Arrays.sort(nums);
        int count = 0;
        int t = 0;
        for(int i = 0; i < len; i++) {
            t = target - nums[i];
            m = i + 1;
            n = len - 1;
            while(m < n) {
                if(nums[m]+nums[n] < t) {
                    count = count + n - m;
                    m++;
                } else {
                    n--;
                }
            }
        }
        return count;
    }
	public static void main(String[] args) {
		int[] a = {-2, 0, 1, 3};
		int target = 2;
		System.out.println(threeSumSmaller(a, target));
	}
	
}
