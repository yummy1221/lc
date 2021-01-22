package leetcode;

import java.util.*;
public class Solution126 {
	public static void main(String[]args) {
		HashSet<String> set = new HashSet<>();
		set.add("hot");
		set.add("dog");
		System.out.println(findLadders("hot", "dog", set));
	}
	private static void findPath(LinkedList<String> rst, HashMap<String, HashSet<String>> map, List<List<String>> rst_set, String endWord) {
        if(!map.containsKey(endWord)) {
            rst_set.add(new LinkedList<String>(rst));
            return;
        }
        for(String s : map.get(endWord)) {
            rst.addFirst(s);
            findPath(rst, map, rst_set, s);
            rst.removeFirst();
        }
    }
    
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> rst_set = new ArrayList<>();
        LinkedList<String> rst = new LinkedList<>();
        LinkedList<String> queue = new LinkedList<>();
        HashMap<String, HashSet<String>> map = new HashMap<>();  // previous string
        HashSet<String> level = new HashSet<>();
        int len = beginWord.length();
        char[] word = beginWord.toCharArray();
        queue.add(beginWord);
        if(wordList.contains(beginWord)) wordList.remove(beginWord);
        int s = 0;
        char tmp = 'a';
        String newWord = "";
        String oldWord = "";
        boolean find = false;
        String find_pre = "";
        while(!queue.isEmpty()) {
            level.clear();
            s = queue.size();
            for(int i = 0; i < s; i++) {
                oldWord = queue.removeFirst();
                word = oldWord.toCharArray();
                for(int j = 0; j < len; j++) {
                    tmp = word[j];
                    for(char k = 'a'; k < 'z'; k++) {
                        if(k != tmp) {
                            word[j] = k;
                            newWord = new String(word);
                            if(newWord.equals(endWord)) {   // find destination
                                find = true;
                                if(!map.containsKey(newWord)) {
                                    map.put(newWord, new HashSet<String>());
                                }
                                map.get(newWord).add(oldWord); 
                                continue;
                            }
                            if(wordList.contains(newWord)) {
                                level.add(newWord);
                                queue.add(newWord);
                                if(!map.containsKey(newWord)) {
                                    map.put(newWord, new HashSet<String>());
                                }
                                map.get(newWord).add(oldWord);   
                            }
                        }
                    }
                    word[j] = tmp;
                }
            }
            if(find) break;
            for(String st : level)
                wordList.remove(st);
        }
        // find path
        if(find) {
        	rst.addFirst(endWord);
        	findPath(rst, map, rst_set, endWord);
        }
        return rst_set;
    }
}
