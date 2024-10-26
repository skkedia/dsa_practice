package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int r = arr.length - k;
        int l = 0;

        while (r > l) {
            int m = l + (r - l) / 2;
            if (x - arr[m] > arr[m + k] - x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
