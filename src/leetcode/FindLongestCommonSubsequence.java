package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindLongestCommonSubsequence {

	public int findLongestConsecutiveSequence(int[] arr) {
		Set<Integer> hs = new HashSet<>();
		for (int i : arr)
			hs.add(i);
		int ans = -1;
		for (int i = 0; i < arr.length; i++) {
			if (!hs.contains(arr[i] - 1)) {
				int num = arr[i];
				while (hs.contains(num)) {
					num++;
				}
				ans = Math.max(ans, num - arr[i]);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		new FindLongestCommonSubsequence().findLongestConsecutiveSequence(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
	}

}
