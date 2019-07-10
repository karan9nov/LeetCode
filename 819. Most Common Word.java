class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> set = new HashSet<>();
        for (String s: banned)
            set.add(s.toLowerCase());

        paragraph = paragraph.toLowerCase();

        String[] words = paragraph.split("[!?',;. ]+");
        Map<String, Integer> map = new HashMap<>();

        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Map<Integer, Set<String>> countMap = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (set.contains(entry.getKey()))
                continue;

            String word = entry.getKey();
            int freq = entry.getValue();

            if (!countMap.containsKey(freq))
                countMap.put(freq, new HashSet<>());
            countMap.get(freq).add(word);
        }

        return countMap.entrySet().iterator().next().getValue().iterator().next();
    }
}
