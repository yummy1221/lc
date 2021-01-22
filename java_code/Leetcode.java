import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Leetcode {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            if (set.size() > k) {
                set.remove(nums[i-k-1]);
            }
            for(Integer j : set) {
                if(Math.abs(nums[i] - j) <= t)
                    return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
	
	public static void main(String[]args) {
		TreeSet<Integer> t = new TreeSet<>();
		List<Integer> a = new ArrayList<>();
		Map<Integer, Integer> b = new HashMap<>();
		t.add(10);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(5);
		a.add(10);
		System.out.println(a.hashCode());
		
	}
}
