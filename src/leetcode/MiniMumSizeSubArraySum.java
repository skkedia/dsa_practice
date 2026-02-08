package leetcode;

public class MiniMumSizeSubArraySum {

	public int minSubArrayLen(int k, int[] nums) {
		int start = 0;
		int end = 0;
		int cur = 0;
		int ans = Integer.MAX_VALUE;
		while (end < nums.length) {
			cur = cur + nums[end];
			while (cur >= k) {
				ans = Math.min(ans, end - start + 1);
				cur = cur - nums[start];
				start++;
			}

			end++;
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

	public static void main(String[] args) {
		System.out.println(new MiniMumSizeSubArraySum().minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(new MiniMumSizeSubArraySum().minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(new MiniMumSizeSubArraySum().minSubArrayLen(4, new int[] { 1, 4, 4 }));

	}

}
