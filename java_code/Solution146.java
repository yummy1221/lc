package leetcode;

public class Solution146 {
	public static void main(String[]args) {
		LRUCache lrc = new LRUCache(2);
		lrc.set(2,1);
		System.out.println(lrc.get(2));
		lrc.set(3,2);
		System.out.println(lrc.get(2));
		System.out.println(lrc.get(3));
		LRUCache.Node node = lrc.tail;
	}
}
