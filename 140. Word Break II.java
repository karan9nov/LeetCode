class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> list = new ArrayList<>();
        Map<Integer, List<String>> map = new LinkedHashMap<>();
        wordBreak(s, 0, new HashSet<>(wordDict), map);
        return list;

    }

    private List<String> wordBreak(String s, int index, Set<String> wordList, Map<Integer, List<String>> map) {

        List<String> stringList = new ArrayList<>();

        if (index == s.length()) {
            // System.out.println(currentString);
            // retval.add(currentString.trim());
            stringList.add("");
            return stringList;
        }

        if (map.containsKey(index)) {
            return map.get(index);
        }

        for (int j = index+1; j <= s.length(); j++) {

            String temp = s.substring(index, j);
            // System.out.println(temp);

            if (wordList.contains(temp)) {

                List<String> tempStringList = tempStringList = wordBreak(s, j, wordList, map);

                for (String tempStr: tempStringList)
                    stringList.add((temp + " " + tempStr).trim());

                System.out.println(index + "=" + stringList);

                // System.out.println(index + "," + currentString + " " + temp);
                // return true;
            }
        }

        map.put(index, stringList);
        System.out.println(map);
        return stringList;

        // return false;
    }
}
