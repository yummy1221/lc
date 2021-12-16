package leetcode;

import java.util.*;

public class Solution23 {
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode rst = new ListNode(0);
        ListNode node = rst;
        int min = Integer.MAX_VALUE;
        int index = 0;
        boolean end = true;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){

			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
        });
        while(end) {
            min = Integer.MAX_VALUE;
            index = -1;
            end = false;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] == null) continue;
                if(!end) end = true;
                if(lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if(end) {
                node.next = lists[index];
                node = node.next;
                lists[index] = lists[index].next;
            }
        }
        return rst.next;
    }
}
