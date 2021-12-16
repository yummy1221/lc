package jobs;

import java.util.ArrayList;
import java.util.Scanner;

public class MyTable<K, V> {
	private int capacity = 97;		// number of buckets in the hash table
	private Node[] bucket = new Node[capacity];
	
	private static class Node<K, V> {
		private K key;
		private V value;
		private Node next;
		Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	private int hash(K key) {
		// Ensure the hash value is positive
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
	public void put(K key, V value) {
		int i = hash(key);
		Node n = bucket[i];
		if(n == null) {
			bucket[i] = new Node(key, value, null);
		} else {
			while(n != null) {
				if(n.key.equals(key)) {
					n.value = value;
					return;
				}
				n = n.next;
			}
			bucket[i] = new Node(key, value, bucket[i]);
		}
	}
	
	public V get(K key) {
		int i = hash(key);
		Node n = bucket[i];
		while(n != null) {
			if(n.key.equals(key)) return (V)n.value;
			n = n.next;
		}
		return null;
	}
	
	public static void main(String[]args) {
		MyTable<String, String> m = new MyTable<>();
        m.put("abc", "eee");
        m.put("ac", "bbb");
        m.put("test","paasss");
        m.put("bc","hh");
        m.put("bsxc","paass");
        m.put("bc","pass"); 
        System.out.println(m.get("abc"));
        System.out.println(m.get("test"));
        System.out.println(m.get("ac"));
        int a = 10;
        double b = 1.2;
        float c = 3.2f;
        long d = 100;
        double e = (a + b) * (c + d);
	}
}
