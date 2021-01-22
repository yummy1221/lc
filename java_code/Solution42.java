import java.util.Stack;

public class Solution42 {
	public static int trap(int[] height) {
        int len = height.length;
        int start = -1;
        Stack<Integer> stack = new Stack<>();
        int top = 0;
        int result = 0;
        boolean first = true;
        for(int i = 0; i < len; i++) {
        	System.out.println();
        	System.out.print("enter " + i + " ");
        	if(first) {
                while(i+1 < len && height[i] <= height[i+1]) i++;
                if(i == len - 1) return 0;
                i--;
                first = false;
                continue;
            }
            start = height[i];
        	System.out.print("start " + start + " " + i + " ");
            while(i+1 < len && height[i] >= height[i+1]) { stack.push(height[i]);  i++; }
            System.out.print("i: "+i + " " + stack.size() + " ");
            if(i == len-1) break;
            while(i+1 < len && height[i] <= height[i+1]) { stack.push(height[i]);  i++; }
            stack.push(height[i]);
            System.out.print(i + " ");
            System.out.print(stack.size() + " ");
            top = Math.min(start, stack.pop());
            System.out.print(top + " ");
            while(stack.size() >1) {
                result = result + Math.max(top - stack.pop(), 0);
            }
            System.out.print(result);
            stack.clear();
            i--;
        }
        return result;
    }
	public static void main(String[] args) {
		int a = 174020040;
		System.out.print(a);
		//System.out.println("result: "+trap(a));
	}
}
