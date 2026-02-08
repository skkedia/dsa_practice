package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountNumbersContainingSpecificDigits {

	public int countValid(int n, int[] arr) {
		// code here
		int low = (int) Math.pow(10, n - 1);
		int high = (int) Math.pow(10, n) - 1;

		Set<Integer> hs = new HashSet<>();
		for (Integer i : arr) {
			hs.add(i);
		}
		int cnt = 0;
		for (int i = low; i <= high; i++) {
			int num = i;
			while (num >= 1) {
				int temp = num % 10;
				num = num / 10;
				if (hs.contains(temp)) {
					cnt++;
					break;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(new CountNumbersContainingSpecificDigits().countValid(1, new int[] { 1, 2, 3 }));

	}

}
