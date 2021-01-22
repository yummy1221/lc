import java.util.*;


public class Solution100 {
	public static void main(String[]args) {
		String nums = "2147483648";
		//System.out.print(nums + ": ");
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 0);
        map.put('-', 0);
        map.put('*', 1);
        Deque<Long> num = new ArrayDeque<>();
        Deque<Character> op = new ArrayDeque<>();
        int len = nums.length();
        long previous = 0;
        long left, right;
        for(int i = 0; i < len; i++) {
            if(map.containsKey(nums.charAt(i))) {
            	num.push(previous);
                previous = 0;
                if(op.isEmpty()) {
                    op.push(nums.charAt(i));
                } else if(map.get(nums.charAt(i)) == 0 && map.get(op.peek()) == 1) {
                	while(!op.isEmpty() && map.get(op.peek()) == 1) {
                		right = num.pop();
                        left = num.pop();
                        op.pop();
                        num.push(left*right);
                	}    
                	// System.out.println(op.size());
                	op.push(nums.charAt(i));
                } else {
                    op.push(nums.charAt(i));
                }
            } else{
            	previous = 10 * previous + (nums.charAt(i) - '0');
                //System.out.println(previous);
            }
        }
        num.push(previous);
        //System.out.println(num.size()+"a");
        //System.out.println(op.size()+"a");
        previous = 0;
        
        //System.out.println(left);
        while(!op.isEmpty() && op.peek() == '*') {
        	right = num.pop();
        	left = num.pop();
        	op.pop();
        	num.push(left * right);
        }
        left = num.pollLast();
        while(!op.isEmpty()) {
            right = num.pollLast();
            char tmp = op.pollLast();
            //System.out.println(left+"  "+tmp+""+right);
            if(tmp == '+') {
                left = left + right;
            } else if(tmp == '-') {
            	left = left - right;
            } else {
            	left = left * right;
            }
        }
        System.out.println(left);
	}
}
