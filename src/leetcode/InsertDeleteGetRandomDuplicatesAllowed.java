package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomDuplicatesAllowed {

	class RandomizedCollection {

		Map<Integer, Set<Integer>> hm;
		List<Integer> list;
		Random rand;

		public RandomizedCollection() {
			hm = new HashMap<>();
			list = new ArrayList<>();
			rand = new Random();
		}

		public boolean insert(int val) {
			if (!hm.containsKey(val)) {
				hm.put(val, new LinkedHashSet<>());
			}
			hm.get(val).add(list.size());
			list.add(val);
			return hm.get(val).size() == 1;
		}

		public boolean remove(int val) {
			if (!hm.containsKey(val) || hm.get(val).size() == 0)
				return false;
			int idx = hm.get(val).iterator().next();
			hm.get(val).remove(idx);
			int last = list.get(list.size() - 1);
			list.set(idx, last);
			hm.get(last).add(list.size() - 1);
			hm.get(last).remove(idx);
			list.remove(list.size() - 1);
			return false;

		}

		public int getRandom() {
			return list.get(rand.nextInt(list.size()));
		}
	}

	public static void main(String[] args) {
	}

}
