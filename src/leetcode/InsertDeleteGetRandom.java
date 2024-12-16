package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

	class RandomizedSet {

		List<Integer> list;
		Map<Integer, Integer> hm;
		Random rand;

		public RandomizedSet() {
			list = new ArrayList<>();
			hm = new HashMap<>();
			rand = new Random();
		}

		public boolean insert(int val) {
			if (hm.containsKey(val)) {
				return false;
			}
			hm.put(val, list.size());
			list.add(val);
			return true;
		}

		public boolean remove(int val) {
			if (!hm.containsKey(val)) {
				return false;
			}
			int lastElement = list.get(list.size() - 1);
			int idx = hm.get(val);
			list.set(idx, lastElement);
			hm.put(lastElement, idx);
			hm.remove(val);
			list.remove(list.size() - 1);
			return true;
		}

		public int getRandom() {
			return list.get(rand.nextInt(list.size()));
		}
	}

	public static void main(String[] args) {

	}

}
