package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s == "")
			return 0;
		if (s.length() == 1)
			return 1;
		Set<Character> set = new HashSet<>();
		int l = 0;
		int r = 0;
		int ans = 0;
		while (r < s.length()) {
			if (!set.contains(s.charAt(r))) {
				set.add(s.charAt(r));
				r++;
				ans = Math.max(ans, set.size());
			} else {
				set.remove(s.charAt(l));
				l++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new LongestSubStringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
		System.out.println(new LongestSubStringWithoutRepeatingCharacters().lengthOfLongestSubstring("au"));
		System.out.println(new LongestSubStringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
	}

}
