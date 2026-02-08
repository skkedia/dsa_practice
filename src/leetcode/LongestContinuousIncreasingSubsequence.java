package leetcode;

public class LongestContinuousIncreasingSubsequence {

	public int findLengthOfLCIS(int[] nums) {
		int max = 0;
		int cur = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				cur++;
			} else {
				max = Math.max(max, cur);
				cur = 1;
			}
		}
		return Math.max(max, cur);
	}

	public static void main(String[] args) {

	}

}
