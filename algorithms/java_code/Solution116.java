package leetcode;

import java.util.LinkedList;

public class Solution116 {
	
	public static void main(String[]args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right = new TreeLinkNode(3);
		root.right.right = new TreeLinkNode(7);
		connect1(root);
		System.out.println(root.next);
		System.out.println(root.left.next.val);
		System.out.println(root.left.left.next.val);
		System.out.println(root.left.right.next.val);
		System.out.println(root.right.next);
		System.out.println(root.right.right.next);
	}
	
	public static void connect1(TreeLinkNode root) {
		if(root == null) return;
		TreeLinkNode next_level = null;
        TreeLinkNode previous = null;
        TreeLinkNode node = root;
        while(node.left != null || node.right != null || node.next != null  || next_level != null) {
            if(node.left != null) {
                if(next_level == null)
                    next_level = node.left;
                if(previous != null) {
                    previous.next = node.left;
                }
                previous = node.left;
            }
            if(node.right != null) {
                if(next_level == null)
                    next_level = node.right;
                if(previous != null) {
                    previous.next = node.right;
                }
                previous = node.right;
            }
            if(node.next == null) {
                node = next_level;
                previous = null;
                next_level = null;
            }
            else 
                node = node.next;
        }
	}
	public static void connect(TreeLinkNode root) {
        if(root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        int countNow, countNext = 0;
        queue.add(root);
        countNow = 1;
        TreeLinkNode tmp = root;
        while(!queue.isEmpty()) {
            tmp = queue.remove();
            countNow--;
            if(countNow == 0) {
                tmp.next = null;
            } else {
                tmp.next = queue.getFirst();
            }
            if(tmp.left != null) {
                queue.add(tmp.left);
                countNext++;
            }
            if(tmp.right != null) {
                queue.add(tmp.right);
                countNext++;
            }
            if(countNow == 0) {
                countNow = countNext;
                countNext = 0;
            }
        }
    }
}
