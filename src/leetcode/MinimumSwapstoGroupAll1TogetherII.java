package leetcode;

public class MinimumSwapstoGroupAll1TogetherII {

	public int minSwaps(int[] nums) {
		int n = nums.length;
		int one = 0;
		for (int i : nums)
			if (i == 1)
				one++;
		int left = 0;
		int winOne = 0;
		int maxone = 0;
		for (int i = 0; i < (2 * n); i++) {
			if (nums[i % n] == 1)
				winOne += 1;
			if (i - left + 1 > one) {
				winOne -= nums[left % n];
				left = left + 1;
			}
			maxone = Math.max(maxone, winOne);
		}
		return one - maxone;
	}

	public static void main(String[] args) {

	}
}