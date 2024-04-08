package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class TopKfrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> mp = new HashMap<>();
		
		
		for(Integer i : nums) {
			mp.put(i, mp.getOrDefault(i, 0) + 1);
		}

		Queue<Integer> ans = new PriorityQueue<>((a, b) -> mp.get(b) - mp.get(a));
		for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
			ans.add(entry.getKey());
		}
		
		int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = ans.poll();
        }

        return result;
	}

}
