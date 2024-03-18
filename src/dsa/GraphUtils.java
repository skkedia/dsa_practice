package dsa;

public class GraphUtils {

    public static boolean isSafe(int i, int j, int n, int m) {
        return i < n && j < m && i >= 0 && j >= 0;
    }

}
