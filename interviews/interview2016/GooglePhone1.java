package jobs;

import java.util.*;
// 1/5/2015
// First Phone Question
public class GooglePhone1 {
	
	/** problem description
	 *  article : apple, banana, cat, dog, dog
	 *  words : cat, banana (true)
	 *  words : dog (true)
	 *  words : apple, apple (false)
	 */
	boolean doesArticleContainWords(List<String> article, List<String> words) {
		HashMap<String, Integer> map = new HashMap<>();
		for(String s : words) {
			if(map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}
		}
		// iterate through article list
		for(String s : article) {
			if(map.containsKey(s) && map.get(s) > 0) {
				map.put(s, map.get(s) - 1);
			}
		}
		// check hashmap
		for(String i : map.keySet()) {
			if(map.get(i) > 0) return false;
		}
		return true;
	}
	/**
	 * article : N, words : K
	 * time : O(N + K)
	 * space : O(K)
	 */
	public static void main(String[]args) {
		GooglePhone1 g = new GooglePhone1();
		List<String> article= new ArrayList<>();
		article.add("apple");
		article.add("banana");
		article.add("cat");
		article.add("dog");
		article.add("dog");
		List<String> words= new ArrayList<>();
		words.add("apple");
		words.add("apple");
		words.add("dog");
		//words.add("cat");
		//words.add("banana");
		System.out.println(g.doesArticleContainWords(article, words));
	}
}
