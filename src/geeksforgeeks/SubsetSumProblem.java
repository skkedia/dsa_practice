package geeksforgeeks;

import java.util.Arrays;

public class SubsetSumProblem {

	static Boolean isSubsetSum(int arr[], int target) {
		Arrays.sort(arr);
		int cur = arr[0];
		int j = 0;
		for (int i = 1; i < arr.length; i++) {
			if (cur == target) {
				return true;
			}
			cur += arr[i];
			while (cur > target && j < arr.length && j <= i) {
				cur = cur - arr[j];
				j++;
			}
		}
		return cur == target;
	}

	public static void main(String[] args) {
		System.out
				.println(isSubsetSum(
						new int[] { 73, 51, 90, 25, 44, 41, 46, 44, 2, 18, 54, 65, 71, 56, 88, 92, 58, 77, 79, 68, 71,
								71, 37, 55, 78, 96, 28, 81, 74, 48, 4, 30, 49, 39, 59, 35, 94, 44, 96, 47, 26, 32, 1, 5,
								40, 37, 56, 33, 80, 11, 16, 86, 77, 19, 24, 63, 91, 66, 34, 40, 56, 4, 10, 54, 93 },
						2857));

	}

}
