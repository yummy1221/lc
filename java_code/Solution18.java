import java.util.*;
public class Solution18 {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        int m, n;
        int t = 0;
        Arrays.sort(nums);
        List<Integer> comp;
        for(int i = 0; i < len; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < len; j++) {
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                m = j+1;
                n = len - 1;
                t = target - nums[i] - nums[j];
                while(m < n) {
                    if(m > j+1 && nums[m] == nums[m-1]) {
                    	m++;
                    	continue;
                    }
                    if(nums[m] + nums[n] == t) {
                        result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[m], nums[n])));
                        m++;
                        n--;
                    } else if (nums[m] + nums[n] < t)
                        m++;
                    else
                        n--;
                }
            }
        }
        return result;
    }
	public static void main(String[] args) {
		int[] a = {-3,-2,-1,0,0,1,2,3};
		int target = 0;
		System.out.println(fourSum(a, target));
	}
}
