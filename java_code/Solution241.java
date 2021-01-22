package leetcode;

import java.util.*;

public class Solution241 {
	
	public static void main(String[]args) {
		String a = "3-4";
		System.out.println(diffWaysToCompute(a));
	}
	
    public static List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();
        int len = input.length();
        int tmp = 0;
        for(int i = 0; i < len; i++) {
            if(Character.isDigit(input.charAt(i))) {
                tmp = tmp * 10 + input.charAt(i) - '0';
            } else {
                nums.add(tmp);
                tmp = 0;
                ops.add(input.charAt(i));
            }
        }
        nums.add(tmp);
        System.out.println(ops);
        return diffWaysToCompute(nums, ops, 0, nums.size() - 1);
    }
    
    public static List<Integer> diffWaysToCompute(ArrayList<Integer> nums, ArrayList<Character> ops, int start, int end) {
        List<Integer> rst = new ArrayList<>();
        // end recursive
        if(start == end) {
            rst.add(nums.get(start));
            return rst;
        }
        if((start + 1) == end) {
        	switch(ops.get(start)) {
            	case '+': rst.add(nums.get(start) + nums.get(end)); break;
            	case '-': rst.add(nums.get(start) - nums.get(end)); break;
            	case '*': rst.add(nums.get(start) * nums.get(end)); break;
            	case '/': rst.add(nums.get(start) / nums.get(end)); break;
        	}
            return rst;
        }
        
        // normal situation
        List<Integer> left, right;
        for(int i = start; i < end; i++) {
            left = diffWaysToCompute(nums, ops, start, i);
            right = diffWaysToCompute(nums, ops, i + 1, end);
            for(Integer x : left) {
                for(Integer y : right) {
                	System.out.println(i);
                    switch(ops.get(i)) {
                        case '+': rst.add(x + y); break;
                        case '-': rst.add(x - y); break;
                        case '*': rst.add(x * y); break;
                        case '/': rst.add(x / y); break;
                    }
                    
                }
            }
        }
        return rst;
    }
}