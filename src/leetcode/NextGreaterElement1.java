package leetcode;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement1 {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums2.length; i++) {
			hm.put(nums2[i], i);
		}
		int[] ans = new int[nums1.length];

		for (int i = 0; i < nums1.length; i++) {
			int res = -1;
			for (int j = hm.get(nums1[i]) + 1; j < nums2.length; j++) {
				if (nums2[j] > nums1[i]) {
					res = nums2[j];
					break;
				}
			}
			ans[i] = res;
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
