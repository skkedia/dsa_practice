package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int rooksLeft(int[][] board) {
		int m = board.length; // Rows
		int n = board[0].length; // Columns

		// Visited array to mark rooks we've already considered
		boolean[][] visited = new boolean[m][n];

		// Function to perform BFS to explore connected rooks
		Queue<int[]> queue = new LinkedList<>();

		int connectedComponents = 0;

		// Start iterating through the board
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					// Start BFS for a new connected component
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
					connectedComponents++;

					// Explore all connected rooks in the same row or column
					while (!queue.isEmpty()) {
						int[] current = queue.poll();
						int x = current[0];
						int y = current[1];

						// Explore the same row
						for (int col = 0; col < n; col++) {
							if (board[x][col] == 1 && !visited[x][col]) {
								visited[x][col] = true;
								queue.offer(new int[] { x, col });
							}
						}

						// Explore the same column
						for (int row = 0; row < m; row++) {
							if (board[row][y] == 1 && !visited[row][y]) {
								visited[row][y] = true;
								queue.offer(new int[] { row, y });
							}
						}
					}
				}
			}
		}

		return connectedComponents;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

		int[][] board1 = { { 1, 0, 1, 0, 0 }, { 1, 0, 1, 0, 0 }, { 1, 0, 1, 1, 0 } };
		System.out.println(solution.rooksLeft(board1)); // Output: 1

		int[][] board2 = { { 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 1 }, { 0, 0, 1, 1, 0 } };
		System.out.println(solution.rooksLeft(board2)); // Output: 1

		int[][] board3 = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		System.out.println(solution.rooksLeft(board3)); // Output: 3

		int[][] board4 = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(solution.rooksLeft(board4)); // Output: 1
	}
}
