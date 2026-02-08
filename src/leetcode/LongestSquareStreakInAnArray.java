package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreakInAnArray {

	public int longestSquareStreak(int[] nums) {
		int ans = 0;

		Set<Integer> hs = new HashSet<>();
		for (Integer i : nums) {
			hs.add(i);
		}

		for (int i = 0; i < nums.length; i++) {
			int curMax = 0;
			long curNum = nums[i];
			while (hs.contains((int) curNum)) {
				curMax++;
				curNum *= curNum;
				if (curNum > 1e5) {
					break;
				}
			}
			ans = Math.max(curMax, ans);
		}
		return ans < 2 ? -1 : ans;
	}

	public static void main(String[] args) {

	}

}
