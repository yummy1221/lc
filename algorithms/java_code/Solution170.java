package leetcode;

import java.util.*;
public class Solution170 {
    Map<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(map.get(number) == null)
	        map.put(number, 0);
	    else if(map.get(number) == 0)
	        map.put(number,1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int i : map.keySet()) {
	        if(map.containsKey(value-i) && ((i != value - i) || map.get(value-i) > 0)) return true;
	    }
	    return false;
	}
	
	public static void main(String[]args) {
		Solution170 s = new Solution170();
		s.add(3);
		s.add(1);
		s.add(5);
		System.out.println(s.find(7));
	}
}