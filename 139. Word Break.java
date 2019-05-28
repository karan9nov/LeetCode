class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, set, 0, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, Set<String> wordSet, int i, Boolean[] memo) {

        if (s.length() == i) return true;

        if (memo[i] != null) {
            return memo[i];
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String temp = s.substring(i, j);
            // System.out.println(temp);
            if(wordSet.contains(temp) && wordBreak(s, wordSet, j, memo)) {
                memo[i] = true;
                return memo[i];
            }
        }

        memo[i] = false;
        return memo[i];
    }
}
