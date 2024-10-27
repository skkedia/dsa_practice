package geeksforgeeks;

import java.util.Arrays;

public class FindTriplets {

	public boolean findTriplet(int[] arr) {
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 0; i--) {
			int start = 0;
			int end = i - 1;
			while (start < end) {
				if (arr[start] + arr[end] == arr[i])
					return true;
				else if (arr[start] + arr[end] < arr[i])
					start++;
				else
					end--;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		new FindTriplets().findTriplet(new int[] { 0, 1, 2, 3 });

		new FindTriplets().findTriplet(new int[] { 8921, 22468, 20392, 27390, 31530, 8847, 26964, 20505, 21692, 7535,
				31540, 18233, 19549, 30152, 12717, 28032, 25526, 23414, 7868, 26691, 22744, 18960, 28208, 6250, 7192,
				30569, 10775, 7450, 22557, 2909 });
		for (int i = 0; i < 5; ++i)
			System.out.println(i);

		for (int i = 0; i < 5; i++)
			System.out.println(i);

		for (int i = 5; i > 0; i--)
			System.out.println(i);

		for (int i = 5; i > 0; --i)
			System.out.println(i);

	}

}
