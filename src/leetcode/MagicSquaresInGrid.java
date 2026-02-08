package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {

	public int numMagicSquaresInside(int[][] grid) {
		if (grid.length < 3 || grid[0].length < 3) {
			return 0;
		}

		int ans = 0;
		int n = grid.length;
		int m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (valid(i, j, n, m, grid)) {
					ans++;
				}
			}
		}
		return ans;
	}

	private boolean valid(int i, int j, int n, int m, int[][] grid) {
		int x = i + 3;
		int y = j + 3;

		if (x > n || y > m) {
			return false;
		}

		int[] arr = new int[10];
		Set<Integer> hs = new HashSet<>();

		for (int p = i; p < x; p++) {
			int z = 0;
			for (int q = j; q < y; q++) {
				if (grid[p][q] > 9) {
					return false;
				}
				arr[grid[p][q]]++;
				z += grid[p][q];
			}
			hs.add(z);
		}

		if (hs.size() != 1) {
			return false;
		}

		for (int p = 1; p < arr.length; p++) {
			if (arr[p] != 1) {
				return false;
			}
		}

		for (int p = j; p < y; p++) {
			int z = 0;
			for (int q = i; q < x; q++) {
				if (grid[q][p] > 9) {
					return false;
				}
				z += grid[q][p];
			}
			hs.add(z);
		}

		int z = 0;
		for (int p = i; p < x; p++) {
			z += grid[p][p + j];
		}
		hs.add(z);
		z = 0;
		for (int p = i; p < x; p++) {
			z += grid[p][x - p - 1 + j];
		}
		hs.add(z);

		if (hs.size() != 1) {
			return false;
		}

		return true;

	}

	public static void main(String[] args) {
		System.out.println(
				new MagicSquaresInGrid().numMagicSquaresInside(new int[][] { { 1, 8, 6 }, { 10, 5, 0 }, { 4, 2, 9 } }));
		System.out.println(new MagicSquaresInGrid()
				.numMagicSquaresInside(new int[][] { { 10, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } }));

	}

}
