package stack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Pair {
	int idx;
	int val;

	Pair(int idx, int val) {
		this.idx = idx;
		this.val = val;
	}
}

public class DailyTemperatures {

	public int maxTotalReward(int[] rewardValues) {
		int ans = 0;
		Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (int i = 0; i < rewardValues.length; i++) {
			pq.add(new Pair(i, rewardValues[i]));
		}
		return ans;

	}

	public static String clearDigits(String s) {
		String ans = "";
		char[] arr = s.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '\0' && Character.isDigit(arr[i])) {
				arr[i] = '\0';
				int a = i;
				while (a >= 0) {
					if (arr[a] != '\0' && Character.isAlphabetic(arr[a])) {
						arr[a] = '\0';
						break;
					}
					a--;
				}
			}
		}
		for (Character i : arr) {
			if (i != '\0')
				ans += i;
		}
		return ans;
	}

	public static int numberOfChild(int n, int k) {
		int flag = 0;
		while (k >= n) {
			k = Math.abs(k - n + 1);
			flag++;
		}
		if (flag % 2 == 0) {
			return k;
		} else {
			return n - k - 1;
		}
	}

	public static int valueAfterKSeconds(int n, int k) {
		int mod = 1000000007;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 1;
		}
		while (k > 0) {
			for (int i = 1; i < arr.length; i++) {
				arr[i] = (arr[i - 1] + arr[i]) % mod;
			}
			k--;
		}
		return arr[n - 1] % mod;
	}

	public int[] dailyTemperatures(int[] temperatures) {
		int[] temp = new int[temperatures.length];

		Stack<Integer> stk = new Stack<>();

		for (Integer i : temperatures) {
			stk.add(i);
		}

		return temp;
	}

	public static void sortColors(int[] nums) {
		int one = 0;
		int zero = 0;
		for (Integer i : nums) {
			if (i == 1) {
				one++;
			} else if (i == 0) {
				zero++;
			}
		}
		for (int i = 0; i < zero; i++) {
			nums[i] = 0;
		}
		for (int i = zero; i < zero + one; i++) {
			nums[i] = 1;
		}
		for (int i = zero + one; i < nums.length; i++) {
			nums[i] = 2;
		}

	}

	public static int countNumberswith4(int n) {
		// code here
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			char[] arr = String.valueOf(i).toCharArray();
			for (Character c : arr) {
				if (c == '4')
					ans++;
			}
		}
		return ans;

	}

	public static int countCompleteDayPairs(int[] hours) {

		int[] rem = new int[24];
		int ans = 0;

		for (int i = 0; i < hours.length; i++) {
			rem[(hours[i] % 24)]++;
		}

		for (int i = 1; i <= 11; i++) {
			ans += rem[i] * rem[24 - i];
		}

		if (rem[12] > 1) {
			ans += ((rem[12] * (rem[12] - 1)) / 2);
		}

		if (rem[0] > 1) {
			ans += ((rem[0] * (rem[0] - 1)) / 2);
		}
		return ans;
	}

	public int solution(String S) {
		int maxLength = 0;
		int N = S.length();

		// First pass: replace '?' with '<'
		maxLength = Math.max(maxLength, maxLengthSymmetric(S, '<'));

		// Second pass: replace '?' with '>'
		maxLength = Math.max(maxLength, maxLengthSymmetric(S, '>'));

		return maxLength;
	}

	public static int minimumOperations(int[] nums) {
		int ans = 0;
		int j = 1 % 3;
		System.out.println(j);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 3 != 0)
				ans += 1;
			// else if(nums[i] % 3 == 1)
			// ans += 1
			// else if(nums[i] % 3)
		}
		return ans;
	}

	private int maxLengthSymmetric(String S, char replaceChar) {
		int maxLength = 0;
		int N = S.length();

		for (int i = 0; i < N; i++) {
			int left = i;
			int right = i;
			int leftCount = 0;
			int rightCount = 0;

			// Expand outwards from the middle
			while (left >= 0 && right < N) {
				if (S.charAt(left) == '<') {
					leftCount++;
				} else if (S.charAt(left) == '>') {
					leftCount--;
				} else { // S.charAt(left) == '?'
					if (replaceChar == '<') {
						leftCount++;
					} else { // replaceChar == '>'
						leftCount--;
					}
				}

				if (S.charAt(right) == '>') {
					rightCount++;
				} else if (S.charAt(right) == '<') {
					rightCount--;
				} else { // S.charAt(right) == '?'
					if (replaceChar == '>') {
						rightCount++;
					} else { // replaceChar == '<'
						rightCount--;
					}
				}

				// Check if it's a valid symmetric substring
				if (leftCount == 0 && rightCount == 0) {
					int currentLength = right - left + 1;
					maxLength = Math.max(maxLength, currentLength);
				}

				left--;
				right++;
			}
		}

		return maxLength;
	}

	public int findPeakElement(int[] nums) {
		int idx = -1;
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mid > 0 && nums[mid - 1] > nums[mid])
				r = mid - 1;
			else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid])
				l = mid + 1;
			else
				return mid;
		}

		return idx;
	}

	public static void main(String[] args) throws Exception {

		try {

		} catch (Exception e) {
			throw new Exception();
		}

		System.out.println(minimumOperations(new int[] { 1, 2, 3, 4 }));

		System.out.println(new DailyTemperatures().solution("<<?"));

		System.out.println(countCompleteDayPairs(new int[] { 1, 23 }));
		System.out.println(countCompleteDayPairs(new int[] { 2, 22 }));
		System.out.println(countCompleteDayPairs(new int[] { 3, 21 }));
		System.out.println(countCompleteDayPairs(new int[] { 4, 20 }));
		System.out.println(countCompleteDayPairs(new int[] { 5, 19 }));
		System.out.println(countCompleteDayPairs(new int[] { 6, 18 }));
		System.out.println(countCompleteDayPairs(new int[] { 7, 17 }));
		System.out.println(countCompleteDayPairs(new int[] { 8, 16 }));
		System.out.println(countCompleteDayPairs(new int[] { 9, 15 }));
		System.out.println(countCompleteDayPairs(new int[] { 10, 14 }));
		System.out.println(countCompleteDayPairs(new int[] { 11, 13 }));
		System.out.println(countCompleteDayPairs(new int[] { 12, 12 }));
		System.out.println(countCompleteDayPairs(new int[] { 13, 11 }));
		System.out.println(countCompleteDayPairs(new int[] { 14, 10 }));
		System.out.println(countCompleteDayPairs(new int[] { 24, 1 }));
	}

}
