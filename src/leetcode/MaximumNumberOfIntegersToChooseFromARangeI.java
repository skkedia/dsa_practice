package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfIntegersToChooseFromARangeI {

	public int maxCount(int[] banned, int n, int maxSum) {
		int cur = 0;
		Set<Integer> hs = new HashSet<>();
		for (int i : banned) {
			hs.add(i);
		}
		int end = 1;
		while (end <= n) {
			if (hs.contains(end)) {
				end++;
				continue;
			}
			if (maxSum - end < 0) {
				return cur;
			}
			maxSum = maxSum - end;
			cur++;
			end++;
		}
		return cur;

	}

	public static void main(String[] args) {
		System.out.println(new MaximumNumberOfIntegersToChooseFromARangeI().maxCount(new int[] { 1, 6, 5 }, 5, 6));

	}

}
