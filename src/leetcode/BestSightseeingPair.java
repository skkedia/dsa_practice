package leetcode;

public class BestSightseeingPair {

	public int maxScoreSightseeingPair(int[] values) {
		int max = -1;
		int maxi = values[0] + 0;

		for (int j = 1; j < values.length; j++) {
			max = Math.max(max, maxi + values[j] - j);
			maxi = Math.max(maxi, values[j] + j);
		}
		return max;
	}

	public static void main(String[] args) {

	}

}
