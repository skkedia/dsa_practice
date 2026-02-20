package leetcode;

import java.util.Arrays;

public class MaximumNumberOfOverLappingIntervals {
    public static int overlapInt(int[][] arr) {
        int[] start = new int[arr.length];
        int[] end = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            start[i] = arr[i][0];
            end[i] = arr[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int over = 0;
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr.length) {
            if (start[i] <= end[j]) {
                over++;
                i++;
                max = Math.max(over, max);
            } else {
                over--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(overlapInt(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
