class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int start = 0, end = 0;
        
        while (end < s.length()) {
            
            while (start < end && set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            
            set.add(s.charAt(end));
            maxLen = Math.max(maxLen, set.size());
            // System.out.println(set);
            end++;
        }
        
        return maxLen;
        
    }
}