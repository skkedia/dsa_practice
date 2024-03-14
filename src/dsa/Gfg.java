package dsa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Gfg implements Serializable {

    public static void main(String[] args) {

        firstIndex(new long[] { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1 }, 10);
        nextGreatest(new int[] { 16, 17, 4, 3, 5, 2 }, 6);

        arranged(new long[] { -1, 2, -3, 4, -5, 6 }, 7);
        collectingCoins(6, new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } });
        collectingCoins(10, new int[][] { { 3, 3 }, { 5, 6 }, { 5, 2 }, { 10, 6 }, { 9, 4 }, { 6, 6 }, { 1, 7 },
                { 10, 1 }, { 10, 5 }, { 8, 7 } });

    }

    private static long firstIndex(long arr[], long n) {
        // Your code goes here
        int start = 0;
        int end = arr.length - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0)) {
                return mid;
            }
            if (arr[mid] == 1)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static void nextGreatest(int arr[], int n) {
        // code here
        int max = -1;
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int tem = arr[i];
            arr[i] = max;
            max = Math.max(max, tem);

        }

    }

    private static boolean isSafe(int r, int c, int i, int j) {
        return i >= 0 && j >= 0 && i < r && j < c;
    }

    private static void dfs(int[][] coins, int row, int col, int i, int j, int d1, int d2) {
        i = i + d1;
        j = j + d2;
        if (!isSafe(row, col, i, j)) {
            return;
        }
        if (coins[i][j] == 1)

            ans += 1;
        dfs(coins, row, col, i, j, d1, d2);
    }

    private static int ans = 0;

    class node {
        int salary;
        String name;

        public void setSalary(int a) {
            this.salary = a;
        }

        public void setName(String s) {
            this.name = s;
        }
    }

    void sortRecords(node arr[], int n) {
        Arrays.sort(arr, new Comparator<node>() {
            @Override
            public int compare(node n1, node n2) {
                if (n1.salary == n2.salary)
                    return n1.name.compareTo(n2.name);
                return n1.salary > n2.salary ? 1 : -1;
            }
        });
    }

    private static ArrayList<Long> arranged(long a[], int n) {
        ArrayList<Long> ans = new ArrayList<>();
        long[] ll = new long[a.length];
        int e = 0;
        int o = 1;
        for (long l : a) {
            if (l % 2 == 0) {
                ll[e] = l;
                e += 2;
            } else {
                ll[o] = l;
                o += 2;
            }
        }
        for (long l : ll)
            ans.add(l);
        return ans;
    }

    public static int collectingCoins(int N, int[][] pp) {

        int[] row = new int[pp.length];
        int[] col = new int[pp.length];
        int[] sum = new int[pp.length];
        int[] dif = new int[pp.length];

        for (int i = 0; i < pp.length; i++) {
            row[i] = pp[i][0];
            col[i] = pp[i][1];
            sum[i] = pp[i][0] + pp[i][1];
            dif[i] = pp[i][0] - pp[i][1];
        }
        Arrays.sort(row);
        Arrays.sort(col);
        Arrays.sort(sum);
        Arrays.sort(dif);
        int maxi = 0;
        int j = 0;
        for (int i = 0; i < row.length;) {
            j = i;
            while (i < row.length && row[i] == row[j]) {
                i++;
            }
            maxi = Math.max(maxi, i - j);
        }
        for (int i = 0; i < col.length;) {
            j = i;
            while (i < col.length && col[j] == col[i]) {
                i++;
            }
            maxi = Math.max(maxi, i - j);
        }
        for (int i = 0; i < sum.length;) {
            j = i;
            while (i < sum.length && sum[j] == sum[i]) {
                i++;
            }
            maxi = Math.max(maxi, i - j);
        }
        for (int i = 0; i < dif.length;) {
            j = i;
            while (i < dif.length && dif[i] == dif[j]) {
                i++;
            }
            maxi = Math.max(maxi, i - j);
        }

        System.err.println(maxi);

        ans = 0;
        int max = -1;
        int maxc = -1;
        int maxr = -1;
        for (int[] arr : pp) {
            maxr = Math.max(arr[0], maxr);
            maxc = Math.max(arr[1], maxc);
        }
        int[][] coins = new int[maxr][maxc];
        for (int[] arr : pp) {
            coins[arr[0] - 1][arr[1] - 1] = 1;
        }
        for (int[] arr : coins)
            System.out.println(Arrays.toString(arr));

        // for (int i = 0; i < coins.length; i++) {
        // for (int j = 0; j < coins[i].length; j++) {
        // for (int[] k : dir) {
        // ans = coins[i][j];
        // dfs(coins, coins.length, coins[i].length, i, j, k[0], k[1]);
        // max = Math.max(ans, max);
        // }
        // }
        // }
        return max;
    }

}
