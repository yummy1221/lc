import java.util.*;

public class Solution15 {
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        int len = nums.length;
        int m = 0, n = 0;
        int target = 0;
        Arrays.sort(nums);
        for(int i = 0; i < len; i++) {
        	//System.out.println(nums[i]);
            target = 0 - nums[i];
            m = i + 1;
            n = len - 1;
            if(i + 3 < len && nums[i+3] == nums[i]) continue; // {0, 0, 0, 0} => [[0, 0, 0]]
            while(m < n) {
                if(nums[m]+nums[n] == target) {
                    lst.add(new ArrayList(Arrays.asList(nums[i], nums[m], nums[n])));
                    break;
                } else if(nums[m]+nums[n] > target) {
                    n--;
                } else {
                    m++;
                }
            }
        }
        return lst;
    }
	public static void main(String[]args) {
		List<List<Integer>> lst = new ArrayList<>();
		lst.add(new ArrayList(Arrays.asList(4,1,2,3)));
		int[] arr = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		System.out.println(threeSum(arr));
		HashSet<ArrayList<Integer>> hs = new HashSet<>();
		hs.add(new ArrayList(Arrays.asList(4,1,2,3)));
		hs.add(new ArrayList(Arrays.asList(4,1,2,3)));
		hs.add(new ArrayList(Arrays.asList(4,1,2,1)));
		hs.add(new ArrayList(Arrays.asList(4,1,2,3)));
		for(ArrayList<Integer> a : hs) 
			System.out.println(a);
		int m = 2, n =3;
		System.out.println((m + n > 6) ? (m--) : (n++));
		//(m + n > 6) ? (m--;) : (n++;);
	}
}
