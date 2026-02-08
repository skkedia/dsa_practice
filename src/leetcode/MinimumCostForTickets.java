package leetcode;

public class MinimumCostForTickets {

	public int mincostTickets(int[] days, int[] costs) {

		int lastDay = days[days.length - 1];
		int dp[] = new int[lastDay + 1];

		int i = 0;
		for (int day = 1; day <= lastDay; day++) {
			if (days[i] > day) {
				dp[day] = dp[day - 1];
			} else {
				i++;
				int cost1 = dp[day - 1] + costs[0];
				int cost7 = dp[Math.max(0, day - 7)] + costs[1];
				int cost30 = dp[Math.max(0, day - 30)] + costs[2];
				dp[day] = Math.min(cost1, Math.min(cost7, cost30));
			}
		}
		return dp[lastDay];
	}

	public static void main(String[] args) {
		System.out.println(
				new MinimumCostForTickets().mincostTickets(new int[] { 1, 4, 6, 7, 8, 20 }, new int[] { 2, 7, 15 }));
	}

}
