package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

	public int slidingPuzzle(int[][] board) {
		// Direction map for zero's possible moves in a 1D representation of the 2x3
		// board
		int[][] directions = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 }, };
		int ans = 0;
		String target = "123450";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				sb.append(board[i][j]);
			}
		}

		Queue<String> qu = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		qu.add(sb.toString());
		visited.add(sb.toString());

		while (!qu.isEmpty()) {
			int size = qu.size();
			for (int i = 0; i < size; i++) {
				String cur = qu.poll();
				if (cur.equals(target)) {
					return ans;
				}
				for (int pos : directions[cur.indexOf('0')]) {
					String next = swap(cur, cur.indexOf('0'), pos);
					if (visited.contains(next)) {
						continue;
					}
					visited.add(next);
					qu.add(next);
				}
			}
			ans++;
		}
		return -1;
	}

	private String swap(String cur, int zer, int pos) {
		StringBuilder sb = new StringBuilder(cur);
		sb.setCharAt(zer, cur.charAt(pos));
		sb.setCharAt(pos, cur.charAt(zer));
		return sb.toString();
	}

	public static void main(String[] args) {

	}

}
