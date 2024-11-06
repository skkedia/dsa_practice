package leetcode;

import java.util.Arrays;

public class MaximumIceCreamBars {

	public int maxIceCream(int[] costs, int coins) {
		Arrays.fill(null, false);
		return solve(costs, coins, costs.length);
	}

	private int solve(int[] costs, int coins, int n) {
		if (coins <= 0 || n == 0) {
			return 0;
		}

		if (costs[n - 1] <= coins) {
			return Math.max(1 + solve(costs, coins - costs[n - 1], n - 1), solve(costs, coins, n - 1));
		} else {
			return solve(costs, coins, n - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
