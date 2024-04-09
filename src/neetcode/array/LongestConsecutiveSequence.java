package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		int ans = 1;
		Set<Integer> set = new HashSet<>();
		for (Integer i : nums) {
			set.add(i);
		}
		for (Integer i : nums) {
			if (!set.contains(i)) {
				int cur = 1;
				while (set.contains(i + 1)) {
					cur++;
					i++;
				}
				ans = Math.max(ans, cur);
			}
			if (ans > nums.length / 2)
				break;
		}
		return ans;
	}

}
