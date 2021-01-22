package leetcode;

import java.util.*;

public class LRUCache {
    public class Node {
        int key;
        int value;
        Node previous;
        Node next;
        public Node() {}
        public Node(int k, int v) {
            key = k;
            value = v;
        }
    }
    
    int capacity;   // maximum size
    int size;       // current size
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.previous = head;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        // move to head
        Node tmp = map.get(key);
        if(tmp.previous != head)
        	move_to_head(tmp);
        return tmp.value;
    }
    
    public void set(int key, int value) {
        if(!map.containsKey(key)) {
            Node node = new Node(key, value);
            node.next = head.next;
            node.previous = head;
            head.next = node;
            node.next.previous = node;
            if(size < capacity) {
                size++;
            } else {
                Node tmp = tail.previous;
                tail.previous = tmp.previous;
                tmp.previous.next = tail;
                map.remove(tmp.key);
            }
            map.put(key, node);
        } else {
            Node tmp = map.get(key);
            tmp.value = value;
            move_to_head(tmp);
        }
    }
    
    private void move_to_head(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.next = head.next;
        node.previous = head;
        head.next = node;
        node.next.previous = node;
    }
}