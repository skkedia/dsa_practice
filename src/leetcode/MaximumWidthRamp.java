package leetcode;

public class MaximumWidthRamp {

	public int maxWidthRamp(int[] nums) {
		int ans = 0;

		int[] rightMax = new int[nums.length];
		rightMax[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
		}

		int left = 0;
		int right = 0;

		while (right < nums.length) {
			while (left < right && nums[left] > rightMax[right]) {
				left++;
			}
			ans = Math.max(ans, right - left);
			right++;
		}

//		int i = 0;
//		while (i < nums.length) {
//			int j = nums.length - 1;
//			while (i < j) {
//				if (nums[i] <= nums[j]) {
//					ans = Math.max(ans, j - i);
//					break;
//				}
//				j--;
//			}
//			i++;
//		}
		return ans;
	}

	public static void main(String[] args) {
		new MaximumWidthRamp().maxWidthRamp(new int[] { 9, 8, 1, 0, 1, 9, 4, 0, 4, 1 });
		new MaximumWidthRamp().maxWidthRamp(new int[] { 6, 0, 8, 2, 1, 5 });
	}

}
