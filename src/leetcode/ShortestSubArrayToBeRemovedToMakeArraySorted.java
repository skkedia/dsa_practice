package leetcode;

import java.util.Arrays;

public class ShortestSubArrayToBeRemovedToMakeArraySorted {

	public int findLengthOfShortestSubarray(int[] arr) {

		arr = new int[] { 1, 2, 3, 10, 4, 2, 3, 5 };
		int[] dp = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= arr[i - 1]) {
				dp[i] = dp[i - 1] + 1;
			} else {
				dp[i] = dp[i - 1];
			}
		}
		System.out.println(Arrays.toString(dp));

		return arr.length - dp[dp.length - 1];

	}

	public static void main(String[] args) {
		System.out.println(new ShortestSubArrayToBeRemovedToMakeArraySorted()
				.findLengthOfShortestSubarray(new int[] { 1, 2, 3, 10, 4, 2, 3, 5 }));

		// 1,2,3,10,4,2,3,5
		// 1,2,3,4, 4,4,5,6
		// 1,2,3
		// 1,2,3

	}

}
