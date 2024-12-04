package leetcode;

public class SearchInRotatedArray {

	public int search(int[] arr, int key) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == key) {
				return mid;
			} else if (arr[left] <= arr[mid]) {// 123 - 1
				if (key > arr[left] && key <= arr[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (key >= arr[mid] && key < arr[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {

	}

}
