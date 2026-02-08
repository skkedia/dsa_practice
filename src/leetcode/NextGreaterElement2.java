package leetcode;

public class NextGreaterElement2 {

	public int[] nextGreaterElements(int[] nums) {
		int[] tem = new int[2 * nums.length];
		int[] ans = new int[nums.length];

		for (int i = 0; i < 2 * nums.length; i++) {
			tem[i] = nums[i % nums.length];
		}
		// int n = nums.length * 2;

		return ans;

	}

	public static void main(String[] args) {
		int[][] directions = new int[][] { { 1, 3, 4 }, { 0, 2, 4 }, { 1, 5 }, { 100, 4 }, { 1, 3, 5 }, { 2, 4 }, };

		for (int i = 0; i < directions.length; i++) {
			for (int j = 0; j < directions[i].length; j++) {
				System.out.println(directions[i][j]);
			}
		}

	}

}
