package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> mp = new HashMap<>();

		for(String str : strs) {
			char[] ch = new char[26];
			for(char c : str.toCharArray()) {
				ch[c - 'a']++;
			}
			String s = new String(ch);
			System.out.println(s);
			if(mp.get(s) == null) {
				mp.put(s, new ArrayList<>());
			}
			mp.get(s).add(str);
		}
		return new ArrayList<>(mp.values());
	}
	
	public static void main(String[] args) {
		GroupAnagrams ga = new GroupAnagrams();
		ga.groupAnagrams(new String[] {"bat", "cat", "mat", "rat", "ate", "atc"});

	}

}
