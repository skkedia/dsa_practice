package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {

	public int tupleSameProduct(int[] nums) {
		int n = nums.length;
		int ans = 0;
		Map<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				hm.put(nums[i] * nums[j], hm.getOrDefault(nums[i] * nums[j], 0) + 1);
			}
		}

		for (int productValue : hm.keySet()) {
			int productFrequency = hm.get(productValue);
			int pairsOfEqualProduct = ((productFrequency - 1) * productFrequency) / 2;
			ans += 8 * pairsOfEqualProduct;
		}

		return ans;
	}

	public static void main(String[] args) {

	}

}
