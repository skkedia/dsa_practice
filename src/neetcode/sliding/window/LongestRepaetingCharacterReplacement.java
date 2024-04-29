package sliding.window;

public class LongestRepaetingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int[] ch = new int[26];
		int l = 0;
		int r = 0;
		int maxo = 0;
		int res = 0;
		while (r < s.length()) {
			ch[s.charAt(r) - 'A']++;
			maxo = Math.max(maxo, ch[s.charAt(r) - 'A']);
			// we get the current window size by r - l, then we subtract 'maxo' to get the
			// number of different characters in that window and we add 1 for the current
			// char as
			// r is updated later in the flow,
			// if this greater than k then we have exhausted all the operations that we can
			// perform
			if (r - l - maxo + 1 > k) {
				ch[s.charAt(l) - 'A']--;
				l++;
			}
			res = Math.max(res, r - l + 1);
			r++;
		}
		return res;
	}
}