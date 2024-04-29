package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int left = i + 1;
			int right = nums.length - 1;
			while (right > left) {
				int three = nums[i] + nums[left] + nums[right];
				if (three > 0) {
					right--;
				} else if (three < 0) {
					left++;
				} else {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(nums[i]);
					tmp.add(nums[left]);
					tmp.add(nums[right]);
					ans.add(tmp);
					left++;
					while (right > left && nums[left] == nums[left - 1]) {
						left++;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new ThreeSum().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}

}
