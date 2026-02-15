package leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }
        int left = binarySearchLeft(nums, target);
        if (left == -1) {
            return new int[] {-1, -1};
        }
        int right = binarySearchRight(nums, target);
        return new int[] {left, right};
    }

    private int binarySearchLeft(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int lower = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                lower = mid;
                high = mid - 1;
            }
        }
        return lower;
    }

    private int binarySearchRight(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int upper = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                upper = mid;
                low = mid + 1;
            }
        }
        return upper;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray =
                new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(findFirstAndLastPositionOfElementInSortedArray
                .searchRange(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

}
