package leetcode;

import java.util.Arrays;

public class MakeBeautifulItemForEachQuery {

	public int[] maximumBeauty(int[][] items, int[] queries) {
		int[] ans = new int[queries.length];
		Arrays.sort(items, (a, b) -> a[0] - b[0]);
		for (int i = 1; i < items.length; i++) {
			items[i][1] = Math.max(items[i][1], items[i - 1][1]);
		}

		for (int i = 0; i < queries.length; i++) {
			ans[i] = doBinarySearch(items, 0, items.length - 1, queries[i]);
		}

		for (int[] arr : items) {
			System.out.println(Arrays.toString(arr));
		}

		return ans;
	}

	private int doBinarySearch(int[][] items, int start, int end, int target) {

		while (end >= start) {
			int mid = start + (end - start) / 2;
			if (items[mid][0] == target) {
				while ((mid + 1 < items.length && items[mid + 1][0] == items[mid][0])) {
					mid++;
				}
				return items[mid][1];
			} else if (items[mid][0] > target) {
				if (mid > 0 && items[mid - 1][0] < target) {
					return items[mid - 1][1];
				}
				end = mid - 1;
			} else {
				if (mid == end && items[mid][0] < target) {
					return items[mid][1];
				}
				start = mid + 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new MakeBeautifulItemForEachQuery().maximumBeauty(
				new int[][] { { 1, 2 }, { 3, 2 }, { 2, 4 }, { 5, 6 }, { 3, 5 } }, new int[] { 1, 2, 3, 4, 5, 6 })));
	}

}
