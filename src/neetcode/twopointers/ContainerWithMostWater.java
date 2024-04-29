package twopointers;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int ans = -1;
		int left = 0;
		int right = height.length - 1;
		while (right > left) {
			int area = (right - left) * Math.min(height[left], height[right]);
			ans = Math.max(ans, area);
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return ans;

	}

	public static void main(String[] args) {
		System.out.println(new ContainerWithMostWater().maxArea(new int[] { 1, 8, 6, 2, 500, 400, 8, 3, 7 }));
		System.out.println(new ContainerWithMostWater().maxArea(new int[] { 1, 1 }));

	}

}
