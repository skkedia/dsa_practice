package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class FindAllPossibleRecipesFromGivenSupplies {

	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		List<String> ans = new ArrayList<>();

		Set<String> sups = new HashSet<>();
		for (String sup : supplies) {
			sups.add(sup);
		}

		Queue<Integer> qu = new LinkedList<>();
		for (int i = 0; i < recipes.length; i++) {
			qu.offer(i);
		}

		int idx = -1;
		while (sups.size() > idx) {
			idx = sups.size();
			int size = qu.size();
			while (size-- > 0) {
				int ridx = qu.poll();
				boolean cancreate = true;

				for (String ind : ingredients.get(ridx)) {
					if (!sups.contains(ind)) {
						cancreate = false;
						break;
					}
				}

				if (!cancreate) {
					qu.offer(ridx);
				} else {
					ans.add(recipes[ridx]);
					sups.add(recipes[ridx]);
				}

			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
