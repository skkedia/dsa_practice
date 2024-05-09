package sliding.window;

import java.util.Arrays;

public class PermutationInString {

	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length())
			return false;
		int[] freq1 = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			freq1[s1.charAt(i) - 'a']++;
		}
		int[] freq2 = new int[26];
		for (int i = 0; i < s2.length(); i++) {
			freq2[s2.charAt(i) - 'a']++;
			if (i >= s1.length()) {
				freq2[s2.charAt(i - s1.length()) - 'a']--;
			}
			if (Arrays.equals(freq1, freq2))
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		new PermutationInString().checkInclusion("", "");
	}

}
