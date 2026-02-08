package geeksforgeeks;

import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Queue;

public class FormTheLargestNumber {

	public String findLargest(int[] arr) {

		Queue<Integer> pq = new PriorityQueue<>((b, a) -> {
			String f = "" + a;
			String s = "" + b;

			if (f.charAt(0) > s.charAt(0)) {
				return 1;
			} else if (f.charAt(0) == s.charAt(0)) {
				int len1 = f.length();
				int len2 = s.length();
				if (len1 > len2) {
					int i = 0;
					while (i < len1) {
						char c = f.charAt(i);
						char d = i < len2 ? s.charAt(i) : s.charAt(len2 - 1);
						if (c > d) {
							return 1;
						} else if (d > c) {
							return -1;
						}
						i++;
					}
				} else if (len2 > len1) {
					int i = 0;
					while (i < len2) {
						char c = s.charAt(i);
						char d = i < len1 ? f.charAt(i) : f.charAt(len1 - 1);
						if (c > d) {
							return -1;
						} else if (d > c) {
							return 1;
						}
						i++;
					}
				} else {
					return f.compareTo(s);
				}
				return 0;
			} else {
				return -1;
			}
		});
		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			System.out.println(pq.peek());
			sb.append(pq.poll());
		}

		BigInteger bi = new BigInteger(sb.toString());

		return bi.toString();

	}

	public static void main(String[] args) {
		System.out.println(1 / 2);
		System.out.println(new FormTheLargestNumber().findLargest(new int[] { 109, 10938 }));
		System.out.println(new FormTheLargestNumber().findLargest(new int[] { 15488, 4044, 877, 15280, 1636, 1281, 362,
				9757, 8749, 1973, 16742, 12069, 18534, 31827, 11245, 7085, 28339, 29957, 29007, 26203, 17004, 20940,
				31068, 77, 13964, 9936, 109, 2570, 10442, 23797, 1444, 6328, 25093, 16558, 28276, 23440, 30181, 29462,
				867, 13712, 17856, 28989, 10766, 8047, 10938, 9663, 110, 26070, 2865, 14492, 15707, 6093, 24408, 4419,
				31310, 14708, 26913, 16112, 19051, 3827, 9057, 15160, 17087, 5043, 11311, 15075, 22470, 29135, 11916,
				249, 13360, 3525, 3914, 26655, 27876, 31346, 24870, 5668 }));
		System.out.println(new FormTheLargestNumber().findLargest(new int[] { 20078, 20220 }));
		System.out.println(new FormTheLargestNumber().findLargest(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(new FormTheLargestNumber().findLargest(new int[] { 54, 546, 548, 60 }));
		System.out.println(new FormTheLargestNumber().findLargest(new int[] { 3, 4, 6, 5, 9 }));

	}

}

// Enhance the
// task management
// system with functionality for
// managing version
// history of tasks,
// allowing rollback
// to previous
// versions and backup/restore of
// user tasks.

// List<String> viewTaskVersions(String taskId) — Returns a list of all historical versions of a
// task, including its current state as the most recent version. Each version is a string in JSON
// format, containing the name, priority, and a sequential

// version number (starting from 0 for the initial state). The list is ordered from oldest to
// newest. A new version is created every time a task is successfully updated via updateTask, even
// if the update results in the same name and

// priority values (no-op updates still create a new version). The returned JSON string's whitespace
// and key order are important; format the string following the examples. Returns an empty list if
// the task does not exist.

// Optional<Integer>

// backupUserTasks(String userId) — Creates a backup of the current set of tasks assigned to a user.
// Overwrites any previous backup for that user. Returns the number of tasks backed up, or
// Optional.empty() if user_id does not exist. Creating a backup for a user with no assigned tasks
// is valid and creates an empty backup, returning 0.

// Optional<Integer> restoreUserTasks(String userId) — This operation replaces the user's current
// list of assigned tasks with the list from the last backup. It does not change

// the content (name, priority) of the tasks themselves, nor does it affect any other users or
// unassigned tasks. Any assignments made to the user after the backup was created will be lost. The
// user retains the same quota they had before restore; the quota does not change as a result of the
// restore operation. The user's quota limits are still enforced after restore; attempting to assign
// additional tasks after restore may fail if the quota is exceeded. Returns the number of tasks in
// the restored set, or Optional.empty() if user_id does not exist. Returns 0 if there is no backup
// to restore from, and keeps the current set of tasks.

/**
 * 1093810910 2022020078 3430359 5454854660 34569
 * 
 * 109 10938 10938 109
 */

// 15488 ,4044 ,877 ,15280 ,1636 ,1281 ,362 ,9757 ,8749 ,1973 ,16742 ,12069 ,18534 ,31827 ,11245
// ,7085 ,28339 ,29957 ,29007 ,26203 ,17004 ,20940 ,31068 ,77 ,13964 ,9936 ,109 ,2570 ,10442 ,23797
// ,1444 ,6328 ,25093 ,16558 ,28276 ,23440 ,30181 ,29462 ,867 ,13712 ,17856 ,28989 ,10766 ,8047
// ,10938 ,9663 ,110 ,26070 ,2865 ,14492 ,15707 ,6093 ,24408 ,4419 ,31310 ,14708 ,26913 ,16112
// ,19051 ,3827 ,9057 ,15160 ,17087 ,5043 ,11311 ,15075 ,22470 ,29135 ,11916 ,249 ,13360 ,3525 ,3914
// ,26655 ,27876 ,31346 ,24870 ,5668
// 99369757966390578778749867804777708563286093566850434419404439143827362352531827313463131031068301812995729462291352900728989286528339282762787626913266552620326070257025093249248702440823797234402247020940197319051185341785617087170041674216558163616112157071548815280151601507514708144921444139641371213360128112069119161131111245110
// 109 10938 1076610442
// 99369757966390578778749867804777708563286093566850434419404439143827362352531827313463131031068301812995729462291352900728989286528339282762787626913266552620326070257025093249248702440823797234402247020940197319051185341785617087170041674216558163616112157071548815280151601507514708144921444139641371213360128112069119161131111245110
// 10938 109 1076610442
