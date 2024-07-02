package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class UnderAge extends Exception {

	UnderAge() {
		super("Not allowed");
	}

}

public class BalancedBinaryTree {

	public class TreeNode {
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

	public TreeNode balanceBST(TreeNode root) {
		List<Integer> al = new ArrayList<>();
		performInoderTraversal(root, al);
		return constructTree(al, 0, al.size() - 1);
	}

	private TreeNode constructTree(List<Integer> al, int low, int high) {
		if (low > high)
			return null;
		int mid = low + (high - low) / 2;
		TreeNode cur = new TreeNode(al.get(mid));
		cur.left = constructTree(al, low, mid - 1);
		cur.right = constructTree(al, mid + 1, high);
		return cur;
	}

	private void performInoderTraversal(TreeNode node, List<Integer> al) {
		if (node == null)
			return;
		performInoderTraversal(node.left, al);
		al.add(node.val);
		performInoderTraversal(node.right, al);
	}

	public int longestCommonSubsequence(String text1, String text2) {
		int[][] dp = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 1; i <= text1.length(); i++) {
			for (int j = 1; j <= text2.length(); j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int n = text1.length();
		int m = text2.length();
		int index = dp[n][m];
		char[] arr = new char[index + 1];

		while (n > 0 && m > 0) {
			if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
				arr[index - 1] = text1.charAt(n - 1);
				n--;
				m--;
				index--;

			} else if (dp[n - 1][m] > dp[n][m - 1]) {
				n--;
			} else {
				m--;
			}
		}
		System.out.println(String.valueOf(arr));

		return dp[text1.length()][text2.length()];
	}

	public long maximumImportance(int n, int[][] roads) {
		long ans = 0l;
		long[] degreeArr = new long[n];

		for (int[] road : roads) {
			degreeArr[road[0]]++;
			degreeArr[road[1]]++;
		}

		Arrays.sort(degreeArr);

		int value = 1;
		for (long edge : degreeArr) {
			ans += (edge * value);
			value++;
		}

		return ans;
	}

	public String pattern(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (isRowPalindrome(arr[i])) {
				return i + " R";
			}
		}
		for (int i = 0; i < arr[0].length; i++) {
			if (isColPalindrome(arr, i)) {
				return i + " C";
			}
		}
		return "-1";
	}

	private boolean isColPalindrome(int[][] arr, int i) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			if (arr[left][i] != arr[right][i]) {
				return false;
			}
			left++;
			right--;
		}
		return false;
	}

	private boolean isRowPalindrome(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			if (arr[left] != arr[right]) {
				return false;
			}
			left++;
			right--;
		}
		return false;
	}

	public List<List<Integer>> getAncestors(int n, int[][] edges) {
		List<List<Integer>> ans = new ArrayList<>();

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
		}

		for (int i = 0; i < n; i++) {
			ans.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[n];
			dfs(i, i, visited, graph, ans);
			ans.get(i).remove(ans.get(i).size() - 1);
		}

		return ans;
	}

	private void dfs(int curr, int ancestor, boolean[] visited, List<List<Integer>> graph, List<List<Integer>> ans) {
		if (visited[curr])
			return;
		visited[curr] = true;
		ans.get(curr).add(ancestor);
		for (Integer neigh : graph.get(curr)) {
			dfs(neigh, ancestor, visited, graph, ans);
		}
	}

	public int findLongestConsecutiveSequence(int[] arr) {
		Set<Integer> hs = new HashSet<>();
		for (int i : arr)
			hs.add(i);
		int ans = -1;
		for (int i = 0; i < arr.length; i++) {
			if (!hs.contains(arr[i] - 1)) {
				int num = arr[i];
				while (hs.contains(num)) {
					num++;
				}
				ans = Math.max(ans, num - arr[i]);
			}
		}
		return ans;
	}

	public int findmaximumSubArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		int cur = 0;
		int s = 0;
		int e = 0;
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			cur = cur + arr[i];
			if (max < cur) {
				max = cur;
				s = j;
				e = i;
			}
			if (cur < 0) {
				cur = 0;
				j = i + 1;
			}
		}
		System.out.println("starting = " + s + " ;ending = " + e);
		return max;
	}

	public int maximumLength(int[] nums) {
		int ans = 0;
		int cur = 1;
		int sub = (nums[0] + nums[1]) % 2;
		for (int i = 2; i < nums.length; i++) {
			if (((nums[i - 1] + nums[i]) % 2) == sub) {
				cur++;
			} else {
				ans = Math.max(cur, ans);
				cur = 0;
				sub = (nums[i - 1] + nums[i]) % 2;
			}
		}
		return Math.max(ans, cur);
	}

	public static void main(String[] args) throws ClassNotFoundException {

		new BalancedBinaryTree().maximumLength(new int[] { 1, 2, 3, 4 });
		new BalancedBinaryTree().findLongestConsecutiveSequence(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 });
		new BalancedBinaryTree().longestCommonSubsequence("AGGTAB", "GXTXAYB");
		try {
			throw new UnderAge();
		} catch (UnderAge u) {
			u.printStackTrace();
			throw new ClassNotFoundException();
		} catch (Exception e) {

		}
	}

}
