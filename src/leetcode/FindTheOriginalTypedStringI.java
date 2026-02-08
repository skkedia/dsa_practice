package leetcode;

public class FindTheOriginalTypedStringI {

	public int possibleStringCount(String word) {
		int ans = 1;

		// int[] freq = new int[26];

		// for(int i = 0; i < word.length(); i++ {
		// freq[word.charAt(i) - 'a']++;
		// }

		// for(int i = 0; i < freq.length; i++) {
		// if(freq[i] > 1) {
		// and += freq[i] - 1;
		// }
		// }

		int left = 0;
		int right = 0;

		while (right < word.length()) {
			while (right < word.length() && word.charAt(left) == word.charAt(right)) {
				right++;
			}

			if (right - left > 1) {
				ans += (right - left - 1);
			}
			left = right;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new FindTheOriginalTypedStringI().possibleStringCount("abbcccc"));
		final Integer i = 0;
		new FindTheOriginalTypedStringI().calladd(i);
		new FindTheOriginalTypedStringI().calladd1(i);
		System.out.println(i);
	}

	private Integer calladd(Integer i) {
		i = i + 1;
		return i;
	}

	private Integer calladd1(Integer i) {
		i = i + 1;
		return i;

	}

}
