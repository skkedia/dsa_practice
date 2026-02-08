package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	List<String> ans = new ArrayList<>();

	Map<Character, char[]> hm = Map.of('2', new char[] { 'a', 'b', 'c' }, '3', new char[] { 'd', 'e', 'f' },

			'4', new char[] { 'g', 'h', 'i' }, '5', new char[] { 'j', 'k', 'l' },

			'6', new char[] { 'm', 'n', 'o' }, '7', new char[] { 'p', 'q', 'r', 's' },

			'8', new char[] { 't', 'u', 'v' }, '9', new char[] { 'w', 'x', 'y', 'z' });

	public List<String> letterCombinations(String digits) {

		int len = digits.length();

		if (len < 1) {
			return ans;
		}
		backtrack(0, digits, new StringBuilder(), len);

		return ans;
	}

	private void backtrack(int idx, String digits, StringBuilder temp, int len) {
		if (idx >= len) {
			ans.add(temp.toString());
			return;
		}

		char[] arr = hm.get(digits.charAt(idx));

		for (int i = 0; i < arr.length; i++) {
			temp.append(arr[i]);
			backtrack(idx + 1, digits, temp, len);
			temp.deleteCharAt(temp.length() - 1);
		}

	}

	public static void main(String[] args) {
		System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));

	}

}
