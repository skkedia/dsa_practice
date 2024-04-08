package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	
	public int orangesRotting(int[][] grid) {
		
		if(grid == null || grid.length == 0)
			return 0;
		
		int cnt = 0;
		
		Queue<int[]> qu = new LinkedList<>();
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j ++) {
				if(grid[i][j] == 2) {
					qu.offer(new int[] {i , j});
				} else if(grid[i][j] == 1) {
					cnt++;
				}
			}
		}
		
		if(cnt == 0)
			return 0;
		int count = 0;
		
		int[][] dirs = new int[][] {{0,1}, {1,0 },{0,-1},{-1, 0}};
		
		while(!qu.isEmpty()) {
			++count;
			int size = qu.size();
			for(int i = 0; i < size; i++) {
				int[] point = qu.poll();
				for(int[] dir : dirs) {
					int x = dir[0] + point[0];
					int y = dir[1] + point[1];
					if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) {
						continue;
					}
					grid[x][y] = 2;
					qu.offer(new int[] {x, y});
					cnt--;
					
				}
			}
		}
		return cnt == 0 ? count - 1 : -1;
    }

}
