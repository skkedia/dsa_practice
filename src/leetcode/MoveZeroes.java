package leetcode;

import java.util.Arrays;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		int n = nums.length;

		int i = 0;
		int j = 0;
		while (i < n && nums[i] != 0) {
			i++;
		}
		j = i;
		while (i < n) {
			while (j < n && nums[j] == 0) {
				j++;
			}
			if (j >= n)
				break;

			nums[i] = nums[j];
			nums[j] = 0;
			i++;
		}

		i = 0;
		for (int k = 0; k < nums.length; k++) {
			if (nums[k] != 0) {
				nums[i++] = nums[k];
			}
		}
		for (int k = i; k < nums.length; k++) {
			nums[k] = 0;
		}
		System.out.print(Arrays.toString(nums));

	}

	public static void main(String[] args) {
		new MoveZeroes().moveZeroes(new int[] { 0, 1, 0, 3, 1, 2 });

	}

}
