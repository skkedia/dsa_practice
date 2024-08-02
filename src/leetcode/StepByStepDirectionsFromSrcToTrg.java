package leetcode;

public class StepByStepDirectionsFromSrcToTrg {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	private Boolean performDfs(TreeNode node, int value, StringBuilder path) {
		if (node == null)
			return false;
		if (node.val == value) {
			return true;
		}
		path.append("L");
		Boolean g = performDfs(node.left, value, path);
		if (g) {
			return true;
		}
		path.setLength(path.length() - 1);
		path.append("R");
		g = performDfs(node.right, value, path);
		if (g) {
			return true;
		}
		path.setLength(path.length() - 1);
		return false;
	}

	public String getDirections(TreeNode root, int startValue, int destValue) {
		StringBuilder sp = new StringBuilder();
		StringBuilder dp = new StringBuilder();
		performDfs(root, startValue, sp);
		performDfs(root, destValue, dp);
		int i = 0;
		while (i < sp.length() && i < dp.length() && sp.charAt(i) == dp.charAt(i)) {
			i++;
		}
		StringBuilder directions = new StringBuilder();
		directions.append("U".repeat(sp.length() - i));
		directions.append(dp.substring(i, dp.length()));
		return directions.toString();
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(6);
		TreeNode t6 = new TreeNode(4);

		t1.left = t2;
		t1.right = t4;

		t2.left = t3;

		t4.left = t5;
		t4.right = t6;

		System.out.println(new StepByStepDirectionsFromSrcToTrg().getDirections(t1, 3, 6));

	}

}
