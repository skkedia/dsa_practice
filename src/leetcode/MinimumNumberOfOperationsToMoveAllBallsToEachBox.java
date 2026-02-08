package leetcode;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

	public int[] minOperations(String boxes) {
		int n = boxes.length();
		int[] ans = new int[n];

		int[] left = new int[n];
		int[] right = new int[n];

		int prev = boxes.charAt(0) == '0' ? 0 : 1;

		for (int i = 1; i < n; i++) {
			left[i] = left[i - 1] + prev;
			prev += boxes.charAt(i) == '0' ? 0 : 1;
		}

		prev = boxes.charAt(n - 1) == '0' ? 0 : 1;
		for (int i = n - 2; i >= 0; i--) {
			right[i] = right[i + 1] + prev;
			prev += boxes.charAt(i) == '0' ? 0 : 1;
		}

		for (int i = 0; i < n; i++) {
			ans[i] = left[i] + right[i];
		}

		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new MinimumNumberOfOperationsToMoveAllBallsToEachBox().minOperations("001011"));

	}

}
