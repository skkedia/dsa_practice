package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SurroundedRegions {

	private int m = 0;
	private int n = 0;

	public void solve(char[][] board) {
		m = board.length;
		n = board[0].length;
		boolean[][] vis = new boolean[m][n];
		for (int i = 1; i < m - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				if (isSafe(i, j, board, vis)) {
					bfs(i, j, board, vis);
				}
			}
		}

	}

	private boolean isSafe(int i, int j, char[][] board, boolean[][] vis) {
		if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O' && !vis[i][j]) {
			return true;
		} else {
			return false;
		}
	}

	private void bfs(int i, int j, char[][] board, boolean[][] vis) {
		Set<String> curvis = new HashSet<>();
		Queue<int[]> qu = new LinkedList<>();
		qu.offer(new int[] { i, j });
		curvis.add(i + "," + j);
		vis[i][j] = true;
		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
		boolean flag = false;
		while (!qu.isEmpty()) {
			int[] curVis = qu.poll();
			for (int[] dir : dirs) {
				int x = curVis[0] + dir[0];
				int y = curVis[1] + dir[1];
				if (isSafe(x, y, board, vis)) {
					vis[x][y] = true;
					if (x == 0 || y == 0 || x == m - 1 || y == n - 1) {
						flag = true;
					}
					curvis.add(x + "," + y);
					qu.offer(new int[] { x, y });
				}
			}
		}
		if (flag)
			return;

		for (String cvis : curvis) {
			int z = Integer.parseInt(cvis.split(",")[0]);
			int y = Integer.parseInt(cvis.split(",")[1]);
			board[z][y] = 'X';
		}
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };

		for (int i = 0; i < board[0].length; i++) {
			System.out.print("  " + i);
		}

		System.out.println();

		for (int i = 0; i < board[0].length; i++) {
			System.out.println(i + " " + Arrays.toString(board[i]));
		}

		new SurroundedRegions().solve(board);

		for (char[] arr : board) {
			System.out.println(Arrays.toString(arr));
		}

	}

	/**
	 * 
	 * 
	 * ["O","X","O","O","O","O","O","O","O"],
	 * 
	 * ["O","O","O","X","O","O","O","O","X"],
	 * 
	 * ["O","X","O","X","O","O","O","O","X"],
	 * 
	 * ["O","O","O","O","X","O","O","O","O"],
	 * 
	 * ["X","O","O","O","O","O","O","O","X"],
	 * 
	 * ["X","X","O","O","X","O","X","O","X"],
	 * 
	 * ["O","O","O","X","O","O","O","O","O"],
	 * 
	 * ["O","O","O","X","O","O","O","O","O"],
	 * 
	 * ["O","O","O","O","O","X","X","O","O"]
	 * 
	 * 
	 */

}
