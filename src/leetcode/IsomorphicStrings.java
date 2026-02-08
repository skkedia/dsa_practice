package leetcode;

import java.util.HashMap;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> smap = new HashMap<>();
		HashMap<Character, Character> tmap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			smap.put(ch1, ch2);
			tmap.put(ch2, ch1);

			if (smap.get(ch1) != tmap.get(ch2)) {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new IsomorphicStrings().isIsomorphic("badc", "baba"));
		System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
	}

}
