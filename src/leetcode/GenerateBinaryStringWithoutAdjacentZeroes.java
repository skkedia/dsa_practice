package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStringWithoutAdjacentZeroes {

	private static List<String> ans = new ArrayList<>();

	public List<String> validStrings(int n) {
		ans = new ArrayList<>();
		helper("0", n);
		helper("1", n);
		return ans;
	}

	private void helper(String s, int n) {
		if (s.length() == n) {
			ans.add(s);
			return;
		}
		if (s.charAt(s.length() - 1) == '0') {
			helper(s + "1", n);
			return;
		}
		helper(s + "0", n);
		helper(s + "1", n);

	}

}
