package dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;

public class Cf {

    private static int calc(int n) {
        try {
            Thread.sleep(1000);
        } catch (Exception es) {

        }
        System.out.println(Thread.currentThread());
        return n * 2;
    }

    private static CompletableFuture<Integer> compute(int n) {
        return CompletableFuture.supplyAsync(() -> calc(n));
    }

    private enum Gender {
        MALE("cb"),
        FEMALE("bb");

        private String bb;

        Gender(String ans) {
            this.bb = ans;
        }

        String getBb() {
            return bb;
        }
    }

    private static int maxOperations(int[] nums) {
        int i = 2;
        int j = 3;
        int ans = 1;
        int res = nums[0] + nums[1];
        while (i < nums.length && j < nums.length) {
            int temp = nums[i] + nums[j];
            i += 2;
            j += 2;
            if (temp == res)
                ans++;
            else
                return ans;
        }
        return ans;
    }

    private static String lastNonEmptyString(String s) {
        int[] arr = new int[26];
        int max = -1;
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
            max = Math.max(max, arr[c - 'a']);
        }
        while (max > 1) {
            int tmp = max;
            for (int i = 0; i < 26; i++) {
                Math.abs(max);
                tmp--;
            }
            max--;
        }

        return s;
    }

    private static int maxProduct(int arr[], int n) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int i : arr) {
            q.add(i);
            if (q.size() > 2) {
                q.poll();
            }
        }
        return q.poll() * q.poll();
    }

    private static boolean isSafe(int i, int j, int clength, int rlength) {
        return i < clength && j < rlength && i >= 0 && j >= 0;
    }

    private Map<Integer, Integer> mp = new HashMap<>();

    private boolean isPrime(String s) {
        Integer i = Integer.parseInt(s);
        System.out.println("check for " + i);
        if (i < 11 || i % 2 == 0)
            return false;
        if (mp.get(i) != null) {
            mp.put(i, mp.get(i) + 1);
            return true;
        }

        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        mp.put(i, 1);
        return true;
    }

    private String s = "";

    public int mostFrequentPrime(int[][] mat) {
        mp = new HashMap<>();
        int ans = -1;
        int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { -1, -1 },
                { 1, -1 } };

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                for (int k = 0; k < dir.length; k++) {
                    s = "" + mat[i][j];
                    dfs(mat, mat.length, mat[j].length, i, j, dir[k][0], dir[k][1]);
                }
            }
        }
        int max = -1;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
            if (entry.getValue() == max) {
                ans = Math.max(ans, entry.getKey());
            }
        }
        return ans;
    }

    private void dfs(int[][] mat, int row, int col, int i, int j, int d1, int d2) {
        i = i + d1;
        j = j + d2;
        if (!isSafe(i, j, row, col))
            return;
        s += mat[i][j];
        isPrime(s);
        dfs(mat, row, col, i, j, d1, d2);
    }

    private static int rangeBitwiseAnd(int left, int right) {
        int ans = left;
        for (int i = left; i <= right; i++) {
            if (ans == 0 || i == 2147483647)
                return ans;
            ans &= i;
        }
        return ans;
    }

    private static int ans = 0;

    public static int maxSum(int n) {
        ans = 0;
        rec(n, 0);
        return Math.max(n, ans);
    }

    private static void rec(int n, int x) {
        if (n == 0)
            return;
        int div2 = n / 2;
        int div3 = n / 3;
        int div4 = n / 4;
        int temp = div2 + div3 + div4;
        ans = Math.max(ans, ans + temp - x);
        rec(div2, div2);
        rec(div3, div3);
        rec(div4, div4);
    }

    public static void main(String[] args) {

        System.out.println(maxSum(12));

        System.out.println(rangeBitwiseAnd(1,
                2));

        System.out.println(rangeBitwiseAnd(2147483646,
                2147483647));

        Cf cf = new Cf();

        System.out.println(cf.mostFrequentPrime(new int[][] { { 9, 3, 8 }, { 4, 2, 5 }, { 3, 8, 6 } }));

        System.out.println(cf.mostFrequentPrime(new int[][] { { 1, 1 }, { 9, 9 }, { 1, 1 } }));

        System.out.println(cf.mostFrequentPrime(new int[][] { { 9, 7, 8 }, { 4, 6, 5 }, { 2, 8, 6 } }));

        System.out.println(maxProduct(new int[] { 1, 100, 42, 4, 23 }, 5));

        System.out.println(lastNonEmptyString("aabcbbca"));

        System.out.println(maxOperations(new int[] { 2, 2, 3, 2, 4, 2, 3, 3, 1, 3 }));

        compute(10).thenApply((data) -> {
            System.out.println(Thread.currentThread());
            return data + 1;
        }).thenAccept(System.out::println);
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (Exception es) {

        }
        System.out.println(Thread.currentThread());
        System.out.println(Gender.valueOf("MALE"));
    }

}
