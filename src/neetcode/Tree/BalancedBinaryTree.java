package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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

	class Node {
		int data;
		Node left;
		Node right;

		Node() {
		}

		Node(int data) {
			this.data = data;
		}

		Node(int data, Node left, Node right) {
			this.data = data;
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

	Map<String, Integer> hm;

	public List<Node> printAllDups(Node root) {
		List<Node> ans = new ArrayList<>();
		hm = new HashMap<>();
		findDup(root, ans);
		return ans;
	}

	private String findDup(Node root, List<Node> ans) {
		if (root == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(root.data).append(",").append(findDup(root.left, ans)).append(",").append(findDup(root.right, ans));
		hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0) + 1);
		if (hm.get(sb.toString()) > 1)
			ans.add(root);
		return sb.toString();
	}

	public int minDifference(int[] nums) {
		int ans = Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : nums) {
			pq.add(i);
			if (pq.size() > 4)
				pq.poll();
		}
		List<Integer> min = new ArrayList<>(pq);
		Collections.sort(min);

		pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i : nums) {
			pq.add(i);
			if (pq.size() > 4)
				pq.poll();
		}
		List<Integer> max = new ArrayList<>(pq);
		Collections.sort(max);

		for (int i = 0; i < 4; i++) {
			ans = Math.min(ans, max.get(i) - min.get(i));
		}

		return ans;
	}

	public static void main(String[] args) throws ClassNotFoundException {

		Thread th = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("hey");
			}
		};

		th.start();

		new BalancedBinaryTree().minDifference(new int[] { 1, 5, 0, 10, 14, -1, -8, 50, 100, 45, 78 });
		new BalancedBinaryTree().maximumLength(new int[] { 1, 2, 3, 4 });

	}

}
