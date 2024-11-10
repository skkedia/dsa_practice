package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {

	public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
		int count = 1;
		List<int[]> idx = new ArrayList<>();
		int start = 0;
		for (int i = 1; i < nums.size(); i++) {
			if (nums.get(i) > nums.get(i - 1)) {
				count++;
				if (i == nums.size() - 1) {
					idx.add(new int[] { start, nums.size() - 1 });
				}
			} else {
				if (count >= k * 2) {
					return true;
				}
				if (count >= k) {
					idx.add(new int[] { start, i - 1 });
				}
				start = i;
				if (i == nums.size() - 1 && start == nums.size() - 1) {
					idx.add(new int[] { nums.size() - 1, nums.size() - 1 });
				}

				count = 1;
			}
		}
		if (count >= k * 2) {
			return true;
		}
		for (int i = 1; i < idx.size(); i++) {
			if ((idx.get(i)[0] - 1 == idx.get(i - 1)[1]) && (idx.get(i)[1] - idx.get(i)[0] + 1 >= k)
					&& (idx.get(i - 1)[1] - idx.get(i - 1)[0] + 1 >= k)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(
				new AdjacentIncreasingSubarraysDetectionI().hasIncreasingSubarrays(Arrays.asList(5, 8, -2, -1), 2));
		System.out.println(
				new AdjacentIncreasingSubarraysDetectionI().hasIncreasingSubarrays(Arrays.asList(-3, -19, -8, -16), 2));
		System.out.println(
				new AdjacentIncreasingSubarraysDetectionI().hasIncreasingSubarrays(Arrays.asList(-2, 14, 0, -4), 2));
		System.out
				.println(new AdjacentIncreasingSubarraysDetectionI().hasIncreasingSubarrays(Arrays.asList(-15, 19), 1));
		System.out.println(
				new AdjacentIncreasingSubarraysDetectionI().hasIncreasingSubarrays(Arrays.asList(2, 5, 4, 5, 4), 2));

	}

}
