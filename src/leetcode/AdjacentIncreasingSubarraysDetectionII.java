package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII {

	public int maxIncreasingSubarrays(List<Integer> nums) {
		int ans = 0;
		int i = 0;
		List<int[]> idx = new ArrayList<>();
		while (i < nums.size()) {
			int j = i + 1;
			while (j < nums.size() && nums.get(j) > nums.get(j - 1)) {
				j++;
			}
			idx.add(new int[] { i, j });
			i = j;
		}
		ans = Math.max(ans, (idx.get(0)[1] - idx.get(0)[0]) / 2);
		for (i = 1; i < idx.size(); i++) {
			ans = Math.max(ans, (idx.get(i)[1] - idx.get(i)[0]) / 2);
			if (idx.get(i)[0] == idx.get(i - 1)[1]) {
				ans = Math.max(ans, Math.min(idx.get(i)[1] - idx.get(i)[0], idx.get(i - 1)[1] - idx.get(i - 1)[0]));
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(
				new AdjacentIncreasingSubarraysDetectionII().maxIncreasingSubarrays(Arrays.asList(-10, 14, 17)));
		System.out.println(new AdjacentIncreasingSubarraysDetectionII()
				.maxIncreasingSubarrays(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)));
		System.out.println(new AdjacentIncreasingSubarraysDetectionII()
				.maxIncreasingSubarrays(Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)));
	}

}
