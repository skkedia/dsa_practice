package leetcode;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

	public int maximumUnits(int[][] boxTypes, int truckSize) {
		int ans = 0;
		if (boxTypes.length == 0 || truckSize == 0) {
			return 0;
		}
		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
		int fill = 0;
		for (int i = 0; i < boxTypes.length; i++) {
			if (truckSize - fill > boxTypes[i][0]) {
				ans += (boxTypes[i][0] * boxTypes[i][1]);
				fill = fill + boxTypes[i][0];
			} else {
				int rem = truckSize - fill;
				ans += (rem * boxTypes[i][1]);
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(
				new MaximumUnitsOnATruck().maximumUnits(new int[][] { { 5, 10 }, { 2, 5 }, { 4, 7 }, { 3, 9 } }, 10));
		System.out.println(new MaximumUnitsOnATruck().maximumUnits(new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } }, 4));
	}

}
