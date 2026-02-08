package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FruitsInABasket {

	public int totalFruit(int[] fruits) {
		if (fruits == null || fruits.length == 0) {
			return 0;
		}
		int ans = -1;
		int left = 0;
		int right = 0;
		int total = 0;
		Map<Integer, Integer> hm = new HashMap<>();
		while (right < fruits.length) {
			hm.put(fruits[right], hm.getOrDefault(fruits[right], 0) + 1);
			total++;

			while (hm.size() > 2) {
				hm.put(fruits[left], hm.getOrDefault(fruits[left], 0) - 1);
				total--;
				if (hm.get(fruits[left]) == 0) {
					hm.remove(fruits[left]);
				}
				left++;
			}
			ans = Math.max(ans, total);
			right++;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new FruitsInABasket().totalFruit(new int[] { 1, 2, 3, 2, 2 }));
	}

}
