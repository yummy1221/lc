import java.util.*;
public class Solution39 {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(result, candidates, target, sum, 0);
        return result;
    }
    
    public static void combinationSum(List<List<Integer>> result, int[] candidates, int target, List<Integer> sum, int index) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(sum));
            return;
        } else if(target < 0)
            return;
        int len = candidates.length;
        for(int i = index; i < len; i++) {
            if(candidates[i] > target) return;
            if(i > 0 && candidates[i] == candidates[i-1]) continue;
            sum.add(candidates[i]);
            combinationSum(result, candidates, target - candidates[i], sum, i);
            sum.remove(sum.size()-1);
        }
    }
    public static void main(String[] args) {
    	int[] a ={92,71,89,74,102,91,70,119,86,116,114,106,80,81,115,99,117,93,76,77,111,110,75,104,95,112,94,73};
    	int target = 310;
    	System.out.println(combinationSum(a, target));
    }
}
