package array;

public class FindPeakElement {

	public int findPeakElement(int[] nums) {
		int idx = -1;
		int l = 0;
		int r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mid > 0 && nums[mid - 1] > nums[mid])
				r = mid - 1;
			else if (mid < nums.length - 1 && nums[mid + 1] > nums[mid])
				l = mid + 1;
			else
				return mid;
		}

		return idx;
	}

	public static void main(String[] args) {
		new FindPeakElement().findPeakElement(new int[] {});
	}

}
