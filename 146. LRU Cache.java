package leetcode.main;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

	int maxCapacity;
	LinkedHashMap<Integer, Integer> map;
	
	/**
	 * Initialize LRU Cache with given capacity
	 * @param capacity
	 */
    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        map = new LinkedHashMap<>();
    }
    
    /**
	 * Main idea is to see if the key exists in the map, then remove that key
	 * and insert it again (insertion at the end), to indicate it was recently used.
	 * If key does not exist return -1
	 * @param key
	 * @return
	 */
    public int get(int key) {
    	if (map.containsKey(key)){
            int tempVal = map.get(key);
    		map.remove(key);
            map.put(key, tempVal);
    		return map.get(key);
    	}
        return -1;
    }
    
	/**
	 * If key is already in the Cache, just remove the key and put it again. if
	 * key is not in the cache, Cache size is greater that or equal to max
	 * capacity, then we need to evict. We will evict Least recently used
	 * element (first element of the map) and put the new value in cache
	 * 
	 * @param key
	 * @param value
	 */
    public void put(int key, int value) {
        // System.out.println("PUT: (" + key + "," + value + ")");
    	int keyToRemove = -1;
        
        if (map.containsKey(key)){
    		map.remove(key);
    	} else if(map.size() >= maxCapacity) {
    		Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
    		keyToRemove = entry.getKey();
    	}
        
    	map.remove(keyToRemove);
    	map.put(key, value);
        // System.out.println(map);
    }
}