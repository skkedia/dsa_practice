package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> hm = new HashMap<>();
        Set<Integer> hs = new HashSet<>();
        for (int[] arr : descriptions) {
            int parent = arr[1];
            int val = arr[0];
            boolean isLeft = arr[2] == 1 ? true : false;

            if (!hm.containsKey(parent)) {
                hm.put(parent, new TreeNode(parent));
            }
            if (!hm.containsKey(val)) {
                hm.put(val, new TreeNode(val));
            }

            if (isLeft) {
                hm.get(parent).left = hm.get(val);
            } else {
                hm.get(parent).right = hm.get(val);
            }
            hs.add(val);
        }

        for (TreeNode val : hm.values()) {
            if (!hs.contains(val.val))
                return val;
        }

        return null;

    }

    public static void main(String[] args) {

    }

}
