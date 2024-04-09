package twopointers;

public class ValidPalindrome {


	public boolean isPalindrome(String s) {
		if (s == null)
			return true;
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			if (!checkChar(s.charAt(left))) {
				left++;
			} else if (!checkChar(s.charAt(right))) {
				right--;
			} else if (lower(s.charAt(right)) != lower(s.charAt(left))) {
				return false;
			} else {
				left++;
				right--;
			}
		}
		return true;
	}

	private char lower(char l) {
		if ((l >= 'a' && l <= 'z') || (l >= '0' && l <= '9'))
			return l;
		return (char) (l + 32);
	}

	private boolean checkChar(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
			return true;
		}
		return false;
	}

}
