package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKPairsWithSmallestSums {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		int m = nums1.length;
		int n = nums2.length;

		while (i < m && j < n && k > 0) {
			List<Integer> cur = new ArrayList<>();
			cur.add(nums1[i]);
			cur.add(nums2[i]);
			if (i < m && nums1[i + 1] < nums2[j]) {
				i++;
			} else {
				j++;
			}
			ans.add(cur);
		}
		return ans;
	}

	public static void main(String[] args) {

	}

}
