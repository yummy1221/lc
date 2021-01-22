public class Solution {
    public static ListNode insertionSortList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode nxt = head.next;
        ListNode end = head;
        ListNode zero = new ListNode(Integer.MIN_VALUE);
        zero.next = head;
        head = zero;
        ListNode i, j;
        int tmp;
        while(nxt!=null) {
        	// System.out.println(end.val);
            if(end.val<=nxt.val) {
                end = end.next;
                nxt = nxt.next;
                continue;
            }
            i = head.next;
            j = head;
            tmp = nxt.val;
            while(true) {
                if(i.val>=tmp) {
                    j.next = nxt;
                    nxt = nxt.next;
                    j.next.next = i;
                    end.next = nxt;
                    break;
                }
                j = i; i = i.next;
            }
        }
        System.out.println(head.next.val);
        return head.next;
    }
    
    public static void main(String[]args) {
    	ListNode a = new ListNode(2);
    	a.next = new ListNode(1);
    	a.next.next = new ListNode(3);
    	a = insertionSortList(a);
    	while(a!=null) {
    		System.out.print(a.val+" ");	
    		a = a.next;
    	}
    }
}