package leetcode;

public class MaximumXOROfTwoNumbersInAnArray {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
    }

    public int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode();
        for (int i = 0; i < nums.length; i++) {
            createTrie(nums[i], root);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, maxXorValue(nums[i], root));
        }
        return max;
    }

    private int maxXorValue(int num, TreeNode root) {
        int max = 0;
        TreeNode crawler = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 1) {
                if (crawler.left != null) {
                    max += Math.pow(2, i);
                    crawler = crawler.left;
                } else {
                    crawler = crawler.right;
                }
            } else {
                if (crawler.right != null) {
                    max += Math.pow(2, i);
                    crawler = crawler.right;
                } else {
                    crawler = crawler.left;
                }
            }
        }
        return max;
    }

    private void createTrie(int num, TreeNode root) {
        TreeNode crawler = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (bit == 0) {
                if (crawler.left == null) {
                    crawler.left = new TreeNode();
                }
                crawler = crawler.left;
            } else {
                if (crawler.right == null) {
                    crawler.right = new TreeNode();
                }
                crawler = crawler.right;
            }
        }
    }

    public static void main(String[] args) {

    }

}
