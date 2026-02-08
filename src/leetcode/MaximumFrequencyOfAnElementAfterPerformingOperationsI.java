package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyOfAnElementAfterPerformingOperationsI {

	public int maxFrequency(int[] nums, int k, int numOperations) {
		int ans = 0;
		Map<Integer, Integer> mp = new HashMap<>();
		Arrays.sort(nums);

		for (int i : nums) {
			mp.put(i, mp.getOrDefault(i, 0) + 1);
		}

		for (int i = 0; i < nums.length; i++) {

		}

		for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			ans = Math.max(ans, entry.getValue());
		}

		return ans;

	}

	public static void main(String[] args) {

	}

}
