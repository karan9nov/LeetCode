class Solution {
	public List<Integer> findAnagrams(String s, String p) {
        
		Map<Character, Integer> map = new HashMap<>();
		List<Integer> retval = new ArrayList<>();
		
		for (char c: p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		Map<Character, Integer> currentMap = new HashMap<>();
		
		int start = 0, end = 0;
		
		while (end - start < p.length() && end < s.length()){
			currentMap.put(s.charAt(end), currentMap.getOrDefault(s.charAt(end), 0) + 1);
			end++;
		}
		
		while (start < s.length() && end < s.length()) {

			if (currentMap.equals(map)) {
				retval.add(start);
			}
			currentMap.put(s.charAt(end), currentMap.getOrDefault(s.charAt(end), 0) + 1);
			currentMap.put(s.charAt(start), currentMap.get(s.charAt(start)) - 1);
			if (currentMap.get(s.charAt(start)) == 0)
				currentMap.remove(s.charAt(start));
			start++;
			end++;
		}
        
        if (currentMap.equals(map)) {
			retval.add(start);
		}

		return retval;
		
    }
}