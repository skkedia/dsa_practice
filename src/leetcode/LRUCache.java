package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	private final Map<Integer, Integer> cache;
	private final Map<Integer, Integer> order;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.cache = new HashMap<>();
		this.order = new LinkedHashMap<>();
	}

	public int get(int key) {
		if (!cache.containsKey(key)) {
			return -1;
		}
		order.remove(key);
		order.put(key, cache.get(key));
		return cache.get(key);
	}

	public void put(int key, int value) {
		if (cache.containsKey(key)) {
			order.remove(key);
		} else if (cache.size() >= capacity) {
			Integer lru = order.keySet().iterator().next();
			order.remove(lru);
			cache.remove(lru);
		}
		cache.put(key, value);
		order.put(key, value);
	}

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		lRUCache.get(1); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		lRUCache.get(2); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		lRUCache.get(1); // return -1 (not found)
		lRUCache.get(3); // return 3
		lRUCache.get(4);
	}

}
