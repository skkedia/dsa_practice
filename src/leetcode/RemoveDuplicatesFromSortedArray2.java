package leetcode;

public class RemoveDuplicatesFromSortedArray2 {
	public int removeDuplicates(int[] nums) {
		int k = 1;

		int cur = nums[0];

		int cnt = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == cur && cnt > 1) {
				continue;
			}
			if (cur != nums[i]) {
				cnt = 1;
				cur = nums[i];
			} else {
				cnt++;
			}
			nums[k++] = nums[i];
		}
		return k;
	}

	public static void main(String[] args) {
		System.out.println(
				new RemoveDuplicatesFromSortedArray2().removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
	}

}
