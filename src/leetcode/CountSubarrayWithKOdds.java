package leetcode;

public class CountSubarrayWithKOdds {

	public int countSubarrays(int[] arr, int k) {
		// code here

		int left = 0;
		int right = 0;
		int n = arr.length;
		int count = 0;
		int cur = 0;
		while (right < n) {
			if (arr[right] % 2 == 1) {
				cur++;
			}
			while (cur > k && left <= right) {
				if (arr[left] % 2 == 1) {
					cur--;
				}
				left++;
			}
			if (cur == k) {
				count++;
			}
			right++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new CountSubarrayWithKOdds().countSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));

	}

}
