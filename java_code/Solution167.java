import java.util.HashMap;
import java.util.Map;

// Leetcode 167, locked
public class Solution167 {
	
	// Method 1: similar to Solution 1
	public static int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            if(target - numbers[i] > numbers[i]) 
            	map.put(numbers[i], i);
            else if(map.containsKey(target - numbers[i])) 
            	return new int[]{map.get(target - numbers[i])+1, i+1};
            else 
            	map.put(numbers[i], i);
        }
        return new int[]{0, 0};
    }
	
	// Method 2:
	public static int[] twoSum2(int[] numbers, int target) {
		int j = numbers.length - 1, i = 0;
        int sum = 0;
        while(i < j) {
            sum = numbers[i] + numbers[j];
            if(sum == target)
                return new int[]{i+1, j+1};
            else if(sum > target)
                j--;
            else
                i++;
        }
        return new int[]{0, 0};
		
	}
	public static void main(String[] args) {
		int[] a = {0, 4, 3, 0};
		int[] b = twoSum2(a, 0);
		System.out.println(b[0] + " " + b[1]);
	}
}
