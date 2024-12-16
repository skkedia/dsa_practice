package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindKMostFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
		List<String> ans = new ArrayList<>();

		Map<String, Integer> frequencyMap = new LinkedHashMap<>();

		for (String word : words) {
			frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> pq = new PriorityQueue<>(
				(a, b) -> frequencyMap.get(a).equals(frequencyMap.get(b)) ? b.compareTo(a)
						: frequencyMap.get(a) - frequencyMap.get(b));

		for (String word : frequencyMap.keySet()) {
			pq.offer(word);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		while (!pq.isEmpty()) {
			ans.add(pq.poll());
		}
		Collections.sort(ans);
		return ans;

	}

	public static void main(String[] args) {

	}

}
