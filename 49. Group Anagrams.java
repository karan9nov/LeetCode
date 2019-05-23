class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap();

        for (String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            if (map.containsKey(temp)) {
                List<String> tempList = map.get(temp);
                tempList.add(str);
            } else {
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                map.put(temp, tempList);
            }
        }

        List<List<String>> retval = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry: map.entrySet())
            retval.add(entry.getValue());

        return retval;
    }
}
