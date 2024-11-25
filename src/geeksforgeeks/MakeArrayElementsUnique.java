package geeksforgeeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayElementsUnique {

	public int minIncrements(int[] arr) {
		Arrays.sort(arr); // 1 2 2
		Set<Integer> hs = new HashSet<>();
		int count = 0;
		hs.add(arr[arr.length - 1]); // hs = 2
		for (int i = arr.length - 2; i >= 0; i--) { // i = 1
			if (arr[i] == arr[i + 1]) { // 2 == 2
				int k = arr[i]; // k = 2
				boolean flag = true;
				while (k - arr[i + 1] < 1 && flag) { // 2-2
					if (!hs.contains(k))
						flag = false;
					count++;
					k++;
				}
				hs.add(k);
			}
			hs.add(arr[i]);
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new MakeArrayElementsUnique().minIncrements(new int[] { 1, 2, 2 }));

	}

}
