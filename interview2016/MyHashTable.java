package jobs;

import java.util.*;

public class MyHashTable<K, V> {
    class Entry<K, V> {
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K key;
        V value;
    }

    private int size = 1000;
    private ArrayList<LinkedList<Entry<K, V>>> ary = new ArrayList<>(size);
    public MyHashTable(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            ary.add(i, null);
        }
    }

    public void put(K key, V value) {
        if (key == null)
            throw new NullPointerException("null of key is not allowed");
        if (ary.get(key.hashCode() % size) == null)
            ary.set(key.hashCode() % size, new LinkedList<Entry<K, V>>());
        ary.get(key.hashCode() % size).addFirst(new Entry<K, V>(key, value));
    }

    public V get(K key) {
        if (key == null)
            throw new NullPointerException("null of key is not allowed");
        if (ary.get(key.hashCode() % size) == null) 
            return null;
        else {
            LinkedList<Entry<K, V>> res = ary.get(key.hashCode() % size);
            Iterator<Entry<K, V>> iterator = res.iterator();
            while (iterator.hasNext()) {
                Entry<K, V> e = iterator.next();
                if (e.key.equals(key))
                    return e.value;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        MyHashTable<String, String> m = new MyHashTable<>(1000);
        m.put("abc", "eee");
        m.put("abc", "bbb");
        m.put("bc","pass"); 
        System.out.println(m.get("abc"));
        System.out.println(m.get("test"));
        System.out.println(m.get("a"));
    }
}