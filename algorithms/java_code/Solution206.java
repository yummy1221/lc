package leetcode;

import java.util.Stack;

public class Solution206 {
	public static ListNode reverseList(ListNode head) {
        if(head == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode tmp = head;
        while(tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        ListNode rst = stack.peek();
        while(!stack.empty()) {
            tmp = stack.pop();
            if(!stack.empty()) {
                tmp.next = stack.peek();
            } else {
            	tmp.next = null;
            }
        }
        return rst;
    }
	
	public static void main(String[]args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		ListNode t = reverseList(a);
		while(t!=null) {
			System.out.println(t.val);
			t = t.next;
		}
	}
}
