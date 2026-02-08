package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class DesignTaskManager {

	class TaskManager {

		Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (b[2] != a[2]) {
				return b[2] - a[2];
			} else {
				return b[1] - a[1];
			}
		});

		Map<Integer, int[]> hm = new HashMap<>();

		public TaskManager(List<List<Integer>> tasks) {
			for (List<Integer> t : tasks) {
				pq.add(new int[] { t.get(0), t.get(1), t.get(2) });
				hm.put(t.get(1), new int[] { t.get(0), t.get(2) });
			}
		}

		public void add(int userId, int taskId, int priority) {
			pq.add(new int[] { userId, taskId, priority });
			hm.put(taskId, new int[] { userId, priority });
		}

		public void edit(int taskId, int newPriority) {
			if (hm.containsKey(taskId)) {
				int[] p = hm.get(taskId);
				hm.put(taskId, new int[] { p[0], newPriority }); // Update task in the map
				pq.add(new int[] { p[0], taskId, newPriority }); // Add updated task to the queue
			}

		}

		public void rmv(int taskId) {
			hm.remove(taskId);
		}

		public int execTop() {
			while (!pq.isEmpty()) {
				int[] top = pq.poll(); // logn
				if (hm.containsKey(top[1]) && hm.get(top[1])[1] == top[2]) {
					hm.remove(top[1]); // Remove the executed task from the map
					return top[0];
				}
			}
			return -1;
		}
	}

//	class Task {
//		int u, id, p;
//
//		Task(int u, int id, int p) {
//			this.u = u;
//			this.id = id;
//			this.p = p;
//		}
//
//		@Override
//		public boolean equals(Object o) {
//			return this.id == ((Task) o).id;
//		}
//
//		@Override
//		public int hashCode() {
//			return u;
//		}
//
//	}

	public static void main(String[] args) {
		// ["TaskManager","edit","execTop"]
		// [[[[2,12,32],[3,27,33],[10,5,23],[8,4,3]]],[4,48],[]]
//		List<List<Integer>> initialTasks = Arrays.asList(Arrays.asList(2, 12, 32), Arrays.asList(3, 27, 33),
//				Arrays.asList(10, 5, 23), Arrays.asList(8, 4, 3));
//		TaskManager tm = new DesignTaskManager().new TaskManager(initialTasks);
//		tm.edit(4, 48);
//		System.out.println(tm.execTop());

		// ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
		// [[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [],
		// [101], [5, 105, 15], []]

//		List<List<Integer>> initialTasks = Arrays.asList(Arrays.asList(1, 101, 10), Arrays.asList(2, 102, 20),
//				Arrays.asList(3, 103, 15), Arrays.asList(4, 104, 5));
//		TaskManager tm = new DesignTaskManager().new TaskManager(initialTasks);
//		tm.edit(102, 8);
//		System.out.println(tm.execTop());

		// ["TaskManager","edit","rmv","execTop"]
		// [[[[7,4,4]]],[4,11],[4],[]]

//		List<List<Integer>> initialTasks = Arrays.asList(Arrays.asList(7, 4, 4));
//		TaskManager tm = new DesignTaskManager().new TaskManager(initialTasks);
//		tm.edit(4, 11);
//		tm.rmv(4);
//		System.out.println(tm.execTop());

		// ["TaskManager","execTop","edit","rmv","execTop","add","execTop","add","execTop","execTop","execTop","execTop"]
		// [[[[10,17,11],[3,1,44]]],[],[17,11],[17],[],[6,6,14],[],[7,28,31],[],[],[],[]]

		List<List<Integer>> initialTasks = Arrays.asList(Arrays.asList(10, 17, 11), Arrays.asList(3, 1, 44));
		TaskManager tm = new DesignTaskManager().new TaskManager(initialTasks);
		System.out.println(tm.execTop());
		tm.edit(17, 11);
		tm.rmv(17);
		System.out.println(tm.execTop());

	}

}
