package jobs;

import java.util.*;

public class WordAbbreviation {
	// Snapchat OA
	public static void main(String[]args) {
		String[] s = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
		WordAbbreviation abb = new WordAbbreviation();
		abb.abbreviations(s);
	}
	
	public void abbreviations(String[] strts) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		String tmp;
		for(String s : strts) {
			tmp = s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1);
			if(!map.containsKey(tmp))
				map.put(tmp, new ArrayList<String>());
			map.get(tmp).add(s);
		}
		for(String s : map.keySet()) {
			if(map.get(s).size() == 1) {
				System.out.println(abb(map.get(s).get(0), 0));
			} else {
				split(map.get(s), 0);
			}
		}
		System.out.println(map);
	}
	
	public void split(ArrayList<String> arr, int index) {
		int len = arr.get(0).length();
		int i = index;
		char tmp = 0;
		boolean b = false;
		while(i < len) {
			tmp = arr.get(0).charAt(i);
			b = false;
			for(int j = 0; j < arr.size(); j++) {
				if(arr.get(j).charAt(i) != tmp) {
					b = true;
					break;
				}
			}
			if(b) break;
			i++;
		}
		HashMap<Character, ArrayList<String>> map = new HashMap<>();
		for(int j = 0; j < arr.size(); j++) {
			if(!map.containsKey(arr.get(j).charAt(i))) {
				map.put(arr.get(j).charAt(i), new ArrayList<String>());
			}
			map.get(arr.get(j).charAt(i)).add(arr.get(j));
		}
		for(char c : map.keySet()) {
			if(map.get(c).size() == 1)
				System.out.println(abb(map.get(c).get(0), i));
			else
				split(map.get(c),i);
		}
	}
	private String abb(String s, int prefix) {
		String tmp = s.substring(0, prefix + 1) + s.length() + s.substring(s.length()-1);
		if(tmp.length() >= s.length())
			return s;
		return tmp;
	}
}
