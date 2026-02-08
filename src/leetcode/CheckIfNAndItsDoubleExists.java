package leetcode;

import java.util.Arrays;

public class CheckIfNAndItsDoubleExists {

	public boolean checkIfExist(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				continue;
			int tar = arr[i] * 2;
			int start = 0;
			int end = arr.length - 1;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (arr[mid] == tar) {
					return true;
				} else if (arr[mid] > tar) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new CheckIfNAndItsDoubleExists().checkIfExist(new int[] { -2, 0, 10, -19, 4, 6, -8 }));
		System.out.println(new CheckIfNAndItsDoubleExists().checkIfExist(new int[] { 10, 2, 5, 3 }));

	}

}
