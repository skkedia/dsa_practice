package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

	public String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		String ans = "";
		Map<Character, Integer> mp = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0) + 1);
		}

		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		Map<Character, Integer> curr = new HashMap<>();
		while (right < s.length()) {
			curr.put(s.charAt(right), curr.getOrDefault(s.charAt(right), 0) + 1);
			if (compare(curr, mp)) {
				do {
					curr.put(s.charAt(left), curr.getOrDefault(s.charAt(left), 0) - 1);
					left++;
				} while (compare(curr, mp));
				if (min > (right - left + 2)) {
					min = right - left + 2;
					ans = s.substring((left - 1), (left + min - 1));
				}
			}
			right++;
		}

		return ans;
	}

	private boolean compare(Map<Character, Integer> curr, Map<Character, Integer> mp) {
		for (Map.Entry<Character, Integer> entries : mp.entrySet()) {
			if (!curr.containsKey(entries.getKey()))
				return false;
			if (curr.get(entries.getKey()) < entries.getValue()) {
				return false;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		new MinimumWindowSubString().minWindow("ADOBECODEBANC", "ABC");

	}

}
