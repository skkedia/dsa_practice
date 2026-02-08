package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubSequence {

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int ans = 0;
		for (int i = 1; i < nums.length; i++) {
			int count = 1;
			for (int j = i; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					count = Math.max(count, dp[j] + 1);
				}
			}
			dp[i] = count;
		}
		int[][] sp = new int[2501][2501];
		for (int[] s : sp) {
			Arrays.fill(s, -1);
		}

		ans = solve(-1, 0, nums, sp);

		ans = Arrays.stream(dp).max().getAsInt();
		return ans;
	}

	private int solve(int p, int c, int[] nums, int[][] sp) {
		if (c > nums.length)
			return 0;

		int take = 0;
		int skip = 0;
		if (p != -1 && sp[c][p] != -1)
			return sp[c][p];
		if (p == -1 || nums[c] > nums[p]) {
			take = 1 + solve(c, c + 1, nums, sp);
		}
		skip = solve(p, c + 1, nums, sp);

		if (p != -1)
			sp[c][p] = Math.max(take, skip);
		return Math.max(take, skip);
	}

	public static void main(String[] args) {

	}

}
