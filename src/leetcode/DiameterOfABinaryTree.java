package leetcode;

public class DiameterOfABinaryTree {

    private int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dia(root);
        return dia;
    }

    private int dia(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dia(node.left);
        int right = dia(node.right);

        dia = Math.max(dia, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        DiameterOfABinaryTree diameterOfBinaryTree = new DiameterOfABinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
    }


}
