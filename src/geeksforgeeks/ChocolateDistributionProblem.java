package geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistributionProblem {

    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int j = 0;
        int min = Integer.MAX_VALUE;
        for (int i = m - 1; i < arr.size(); i++) {
            min = Math.min(min, arr.get(i) - arr.get(j));
            j += 1;
        }
        return min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(1);
        arr.add(9);
        arr.add(56);
        arr.add(7);
        arr.add(9);
        arr.add(12);
        int m = 5;
        ChocolateDistributionProblem chocolateDistributionProblem =
                new ChocolateDistributionProblem();
        System.out.println(chocolateDistributionProblem.findMinDiff(arr, m));
    }

}
