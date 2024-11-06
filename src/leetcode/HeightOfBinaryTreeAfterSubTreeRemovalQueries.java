package leetcode;

import java.util.Arrays;

public class HeightOfBinaryTreeAfterSubTreeRemovalQueries {

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        int[] nodeLevel = new int[10001];
        int[] nodeHeight = new int[10001];
        int[][] topHeight = new int[10001][2];

        Arrays.fill(nodeLevel, -1);

        findHeight(root, 0, nodeLevel, nodeHeight, topHeight);

        int i = 0;
        for (Integer query : queries) {
            int level = nodeLevel[query];
            int height = nodeHeight[query];

            int maxHeight =
                    topHeight[level][0] == height ? topHeight[level][1] : topHeight[level][0];

            ans[i++] = maxHeight + level - 1;
        }

        return ans;
    }

    private int findHeight(TreeNode root, int level, int[] nodeLevel, int[] nodeHeight,
            int[][] topheight) {
        if (root == null)
            return 0;

        int height =
                1 + Math.max(findHeight(root.left, level + 1, nodeLevel, nodeHeight, topheight),
                        findHeight(root.right, level + 1, nodeLevel, nodeHeight, topheight));
        nodeLevel[root.val] = level;
        nodeHeight[root.val] = height;

        /*
         * here we are storing the greatest element in the 0th index and the 2nd greatest in the 1st
         * index
         * 
         * so we check if height is greater than 0th index element if yes then we first swap it to
         * the 1st index and then set 0th index to height
         */

        if (topheight[level][0] < height) {
            topheight[level][1] = topheight[level][0];
            topheight[level][0] = height;
        } else if (topheight[level][1] < height) {
            topheight[level][1] = height;
        }
        return height;
    }

    public static void main(String[] args) {


    }

}
