import java.util.*;

public class Solution16 {
	public static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int m = 0, n = 0;
        int t = 0;
        Arrays.sort(nums);
        int closest = Math.abs(nums[0]+nums[1]+nums[2]-target);
        for(int i = 0; i < len; i++) {
            t = target - nums[i];
            m = i + 1;
            n = len - 1;
            while(m < n) {
                if(nums[m]+nums[n] == t) {
                    return 0;
                } else{
                    if(Math.abs(nums[m]+nums[n]-t) < closest)
                        closest = Math.abs(nums[m]+nums[n]-t);
                    System.out.println(m+" "+n+" "+i+" "+closest);
                    if(nums[m]+nums[n] > t) {
                        n--;
                    } else {
                        m++;
                    }
                }
            }
        }
        return closest;
    }
	public static void main(String[] args) {
		int[] a = {-1, 2, 1, -4};
		int target = 1;
		System.out.println(threeSumClosest(a, target));
	}
}
