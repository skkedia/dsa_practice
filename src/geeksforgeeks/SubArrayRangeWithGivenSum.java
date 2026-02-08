package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;

public class SubArrayRangeWithGivenSum {

	static int subArraySum(int[] arr, int tar) {
		int ans = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		hm.put(0, 1);
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (hm.containsKey(sum - tar)) {
				ans += hm.get(sum - tar);
			}
			hm.put(sum, hm.getOrDefault(sum, 0) + 1);
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
