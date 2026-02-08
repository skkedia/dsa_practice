package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MinimumIncrementToMakeArrayUnique {

	public int minIncrementForUnique(int[] nums) {
		Set<Integer> used = new HashSet<>();
		int moves = 0;

		for (int num : nums) {
			int x = num;

			while (used.contains(x)) {
				x++;
				moves++;
			}

			used.add(x);
		}
		return moves;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumIncrementToMakeArrayUnique().minIncrementForUnique(new int[] { 1, 2, 2 }));

	}

}
