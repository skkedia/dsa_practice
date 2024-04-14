package twopointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {

	/**
	 * TC - O(N) SC - O(N)
	 * 
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (mp.containsKey(target - nums[i])) {
				return new int[] { mp.get(target - nums[i]) + 1, i + 1 };
			}
			mp.put(nums[i], i);
		}
		return null;
    }

	public int[] twoSum2(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return nums;
		}
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			if (nums[left] + nums[right] == target) {
				return new int[] { left + 1, right + 1 };
			} else if (nums[left] + nums[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return new int[] { -1, -1 };
	}

}
