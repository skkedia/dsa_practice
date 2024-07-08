package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindTheWinnerOfACircularGame {

	public int findTheWinner(int n, int k) {
		List<Integer> ll = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			ll.add(i);

		int startIndex = 0;

		while (ll.size() != 1) {
			startIndex = (startIndex + k - 1) % ll.size();
			ll.remove(startIndex);
		}

		return ll.get(0);

	}

	public static void main(String[] args) {
		System.out.println(new FindTheWinnerOfACircularGame().findTheWinner(5, 2));

	}

}
