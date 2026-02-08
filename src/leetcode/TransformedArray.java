package leetcode;

public class TransformedArray {

	public int[] constructTransformedArray(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				result[i] = nums[i];
			} else {
				// Calculate the new index after moving nums[i] steps
				int newIndex = (i + nums[i]) % n;
				// Adjust for negative indices
				if (newIndex < 0) {
					newIndex += n;
				}
				result[i] = nums[newIndex];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new TransformedArray().constructTransformedArray(new int[] { -10, -1 }));
		System.out.println(new TransformedArray().constructTransformedArray(new int[] { -10, -10, -4 }));
		System.out.println(new TransformedArray().constructTransformedArray(new int[] { -10 }));
		System.out.println(new TransformedArray().constructTransformedArray(new int[] { 3, -2, 1, 1 }));
		System.out.println(new TransformedArray().constructTransformedArray(new int[] { -1, 4, -1 }));
		System.out.println(-10 % 3);

	}

}
