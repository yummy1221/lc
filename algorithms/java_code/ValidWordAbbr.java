package leetcode;

import java.util.*;

public class ValidWordAbbr {

	public static void main(String[] args) {
		String[] dictionary = { "dog", "a" };
		ValidWordAbbr vw = new ValidWordAbbr(dictionary);
		System.out.println(vw.isUnique("dig"));
	}

	HashMap<String, String> map;

	public ValidWordAbbr(String[] dictionary) {
		map = new HashMap<String, String>();
		int len = dictionary.length;
		String tmp = "";
		for (String s : dictionary) {
			if (s.length() <= 2)
				tmp = s;
			else
				tmp = s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1);
			if (!map.containsKey(tmp)) {
				map.put(tmp, s);
			} else {
				if (map.get(tmp) == null || map.get(tmp).equals(s)) {
					continue;
				} else {
					map.put(tmp, null);
				}
			}
		}
	}

	public boolean isUnique(String word) {
		String tmp = "";
		if (word.length() > 2) {
			tmp = word.substring(0, 1) + (word.length() - 2) + word.substring(word.length() - 1);
		} else
			tmp = word;
		if (!map.containsKey(tmp)) {
			return true;
		} else {
			String s = map.get(tmp);
			if (s == null)
				return false;
			else if (s.equals(word))
				return true;
			else
				return false;
		}
	}
}

// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");