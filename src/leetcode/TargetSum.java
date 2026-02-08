package leetcode;

import java.util.Arrays;

public class TargetSum {

	public int findTargetSumWays(int[] nums, int target) {
		return calculateBacktracking(nums, 0, target, 0);
	}

	private int calculateBacktracking(int[] nums, int idx, int target, int sum) {
		if (idx == nums.length) {
			if (sum == target) {
				return 1;
			} else {
				return 0;
			}
		}

		int add = calculateBacktracking(nums, idx + 1, target, sum + nums[idx]);
		int sub = calculateBacktracking(nums, idx + 1, target, sum - nums[idx]);
		return add + sub;
	}

	public static void main(String[] args) {

	}

	int solution(int[] numbers) {
		int ans = 0;
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			int cur = numbers[i];
			String z = String.valueOf(cur);
			for (int j = i + 1; j < numbers.length; j++) {
				String x = String.valueOf(numbers[j]);
				if ((x.equals(z)) || (x.length() == z.length() && numOfSwaps(z, x))) {
					ans++;
				}
			}
		}
		return ans;
	}

	// the idea her is to find out the number swaps required to become the original
	// number
	private boolean numOfSwaps(String i, String j) {
		System.out.println("checking for " + i + " and " + j);
		char[] iarr = i.toCharArray();
		char[] jarr = j.toCharArray();
		int num = 0;
		// Map<Integer, Integer> hm = new HashMap<>();

		// make the 1st element to second element
		for (int z = 0; z < iarr.length; z++) {

		}

		for (int z = 0; z < iarr.length; z++) {
			if (iarr[z] != jarr[z]) {
				num += 1;
			}
			System.out.println("i = " + iarr[z] + " ; j = " + jarr[z] + " ; nums " + num);
		}
		if (num > 2) {
			System.out.println("false");
			return false;
		}
		return true;
	}
	// 0 - given an array find reutrn an array, ans[i] = 1, if arr[i - 1] > arr[i] <
	// arr[i + 1] or arr[i - 1] < arr[i] > arr[i + 1]
	// 1 -
	// 2 - find the nth consonant and change to the next consonant
	// 3 - given supply logs find the sell prices
	// 4 - given an array of nums, find out the number of pairs which can be equal
	// with 2 or less swaps

}
