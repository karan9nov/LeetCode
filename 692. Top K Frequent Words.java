class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String str: words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        };

        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(comparator);

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (treeMap.containsKey(entry.getValue())) {
                treeMap.get(entry.getValue()).add(entry.getKey());
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(entry.getKey());
                treeMap.put(entry.getValue(), tempList);
            }
        }

        List<String> retval = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry: treeMap.entrySet()) {
            Collections.sort(entry.getValue());
            while(k > 0 && !entry.getValue().isEmpty()) {
                retval.add(entry.getValue().get(0));
                entry.getValue().remove(0);
                k--;
            }
            if (k == 0) return retval;
        }

        return retval;
    }
}
