package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		int ans = 0;
		int sum = 0;
		Map<Integer, Integer> pre = new HashMap<>();
		pre.put(0, 1);
		for (Integer i : nums) {
			sum += i;
			ans += pre.getOrDefault(sum - k, 0);
			pre.put(sum, pre.getOrDefault(sum, 0) + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new SubArraySumEqualsK().subarraySum(new int[] { 1, 2, 3 }, 3));
		System.out.println(new SubArraySumEqualsK().subarraySum(new int[] { 1, 1, 1 }, 2));

	}

}
