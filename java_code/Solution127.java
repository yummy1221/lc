package leetcode;

import java.util.*;

public class Solution127 {
    // BFS
	
	public static void main(String[]args) {
		String begin = "a", end = "c";
		HashSet<String> wordList = new HashSet<>();
		wordList.add("a");
		wordList.add("b");
		wordList.add("c");
		int a = ladderLength(begin, end, wordList);
		System.out.println(a);
	}
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<String> queue = new LinkedList<>();
        int len = beginWord.length();
        char[] word = beginWord.toCharArray();
        queue.add(beginWord);
        int count = 1;
        int s = 0;
        char tmp = 'a';
        int alpha = 26;
        while(!queue.isEmpty()) {
            s = queue.size();
            System.out.println(queue);
            for(int i = 0; i < s; i++) {
                word = queue.removeFirst().toCharArray();
                if(endWord.equals(new String(word))) return count;
                for(int j = 0; j < len; j++) {
                	tmp = word[j];
                    for(int k = 0; k < alpha; k++) {
                        if(k != tmp - 'a') {
                            word[j] = (char)(k + 'a');
                            if(wordList.contains(new String(word))) {
                                queue.add(new String(word));
                                wordList.remove(new String(word));
                            }
                        }
                    }
                    word[j] = tmp;
                }
            }
            count++;
        }
        return 0;
    }
}