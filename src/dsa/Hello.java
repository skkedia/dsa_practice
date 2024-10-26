package dsa;

public class Hello implements Runnable {

    /**
     * Given a sorted array, find the first and the last occurance of a given number
     * {1,2,2,2,2,4,5,5,5,5,5,7,11} n = 5
     * 
     * Output -> 6,10
     * 
     */

    private int findLeftIndex(int n, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int idx = -1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == n) {
                idx = mid;
                right = mid - 1;
            } else if (arr[mid] > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }

    private int findRightIndex(int n, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int idx = -1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == n) {
                idx = mid;
                left = mid + 1;
            } else if (arr[mid] > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }

    private void findFirstAndLastIndex(int n, int[] arr) {

        int leftIndex = findLeftIndex(n, arr);
        int rightIndex = findRightIndex(n, arr);
        System.out.println("left -- " + leftIndex + " ;right - " + rightIndex);
    }

    /**
     * Given an integer array, we need to find the length of the maximum size subset whose sum is
     * equal to the given sum. Examples: Input : set[] = {2, 3, 5, 7, 10, 15}, sum = 10 Output : 3
     * Explanation: The largest sized subset with sum 10 is {2, 3, 5}
     * 
     * Input : set[] = {1, 0, 2, 3, 4, 5, 6}, sum = 4 Output : 2 {1, 3,
     * 
     * @param args
     */

    public int findMaxSubSetLength(int[] arr, int target) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {

        }

        return -1;
    }

    /**
     * s1 = abcd s2 = cdsa ans = 2
     * 
     * s1 = AGGTAB s2 = GXTXAYB ans = 4
     * 
     * s1 = abcd s2 = acds ans = 3
     * 
     * 
     * A G G T A B
     * 
     * G 0 1 1 X T X A Y B *
     * 
     * 
     * 
     * @param args
     */

    private int findLongestCommonSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[s.length() - 1][t.length() - 1];
    }

    /**
     * S i d d h a n t S i d h u
     * 
     * 
     * char[26] arr = 1st string, populate freq char[26] arr = 2st string, decre freq from arr
     * 
     * 
     * 
     * arr -> left over char
     * 
     * figure flames logic S S
     * 
     * 
     * 
     * 
     * @param name1
     * @param name2
     * @return
     */

    private Character findFlamesValue(String name1, String name2) {

        int[] arr = new int[26];
        int[] brr = new int[26];
        name1 = name1.toLowerCase();
        name2 = name2.toLowerCase();
        for (Character c : name1.toCharArray()) {
            arr[c - 'a']++;
        }
        for (Character c : name2.toCharArray()) {
            brr[c - 'a']++;
        }
        int sumOfLstfOverChar = 0;

        for (int i = 0; i < arr.length; i++) {
            sumOfLstfOverChar += (Math.abs(arr[i] - brr[i]));
        }
        System.out.println(sumOfLstfOverChar);
        // F L A M E S //5
        String ss = "FLAMES"; // 11

        int startIndex = 0;
        while (ss.length() != 1) {
            startIndex = (startIndex + sumOfLstfOverChar - 1) % ss.length();
            ss = ss.substring(0, startIndex) + ss.substring(startIndex + 1, ss.length());
            System.out.println(ss);
        }
        System.out.println(ss);
        return ss.charAt(0);
    }

    public static void main(String[] args) {
        Thread th = new Thread(new Hello());
        th.setPriority(10);
        th.start();
        System.out.println("bye");
        new Hello().findFlamesValue("Siddhant", "Siddhantttttttttttttttttt");
        new Hello().findFirstAndLastIndex(8, new int[] {5, 7, 7, 8, 8, 10});
        System.out.println(new Hello().findLongestCommonSubsequence("AGGTAB", "GXTXAYB"));

    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hi");
    }

}
