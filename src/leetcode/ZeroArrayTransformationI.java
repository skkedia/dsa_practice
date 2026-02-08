package leetcode;

public class ZeroArrayTransformationI {

	public boolean isZeroArray(int[] nums, int[][] queries) {
		int[] arr = new int[nums.length + 1];
		for (int[] query : queries) {
			arr[query[0]] = arr[query[0]] - 1;
			arr[query[1] + 1] = arr[query[1] + 1] + 1;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += arr[i];
			if (nums[i] + sum > 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new ZeroArrayTransformationI().isZeroArray(new int[] { 2 },
				new int[][] { { 0, 0 }, { 0, 0 }, { 0, 0 } }));

	}

}
