package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfDistinctSubarraysWithLengthK {

	public long maximumSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> hm = new HashMap<>();
		long ans = 0l;
		long sum = 0l;
		int end = 0;
		int start = 0;

		while (end < nums.length) {
			int lo = hm.getOrDefault(nums[end], -1);
			while (lo >= start || end - start + 1 > k) {
				sum -= nums[start];
				start++;
			}
			hm.put(nums[end], end);
			sum += nums[end];
			if (end - start + 1 == k)
				ans = Math.max(ans, sum);
			end++;
		}
		return ans;

	}

	public static void main(String[] args) {
		System.out.println(
				new MaximumSumOfDistinctSubarraysWithLengthK().maximumSubarraySum(new int[] { 1, 1, 1, 7, 8, 9 }, 3));
		System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK().maximumSubarraySum(new int[] { 3, 3, 3 }, 1));
		System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK().maximumSubarraySum(new int[] { 3, 3, 3 }, 2));
		System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK().maximumSubarraySum(new int[] { 3, 3, 3 }, 3));
		System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK().maximumSubarraySum(new int[] { 1, 2, 3 }, 2));
		System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK().maximumSubarraySum(new int[] { 1, 2, 3 }, 3));
		System.out.println(new MaximumSumOfDistinctSubarraysWithLengthK()
				.maximumSubarraySum(new int[] { 1, 5, 4, 2, 9, 9, 9 }, 3));

	}

}
