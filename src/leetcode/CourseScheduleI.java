package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adj = new ArrayList<>();
		int[] vis = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}

		for (int[] pre : prerequisites) {
			adj.get(pre[1]).add(pre[0]);
			vis[pre[0]]++;
		}
		Queue<Integer> qu = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (vis[i] == 0) {
				qu.offer(i);
			}
		}

		int nod = 0;
		while (!qu.isEmpty()) {
			int cur = qu.poll();
			nod++;
			for (Integer p : adj.get(cur)) {
				vis[p]--;
				if (vis[p] == 0) {
					qu.offer(p);
				}
			}
		}

		return nod == numCourses;
	}

	public static void main(String[] args) {
		System.out.println(new CourseScheduleI().canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(new CourseScheduleI().canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));

	}

}
