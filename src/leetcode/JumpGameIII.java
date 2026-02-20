package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        int n = arr.length;
        boolean[] vis = new boolean[n];
        Queue<Integer> qu = new LinkedList<>();

        qu.offer(start);
        vis[start] = true;

        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int v = qu.poll();
                int x = v - arr[v];
                int y = v + arr[v];

                if (x >= 0) {
                    if (arr[x] == 0)
                        return true;
                    if (!vis[x]) {
                        vis[x] = true;
                        qu.offer(x);
                    }
                }
                if (y < n) {
                    if (arr[y] == 0)
                        return true;
                    if (!vis[y]) {
                        vis[y] = true;
                        qu.offer(y);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGameIII jumpGameIII = new JumpGameIII();
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        System.out.println(jumpGameIII.canReach(arr, start));
    }
}
