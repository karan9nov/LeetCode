public int lengthOfLongestSubstring(String s) {

    if (s == null || s.length() == 0)
        return 0;

    int maxLen = 0;
    Set<Character> currentWordSet = new LinkedHashSet<>();
    int start = 0; int end = 0;

    int currentLen = 0;

    while(start <= end && end < s.length()) {

        while (currentWordSet.contains(s.charAt(end))) {
            maxLen = Math.max(maxLen, currentLen);
            currentWordSet.remove(s.charAt(start));
            currentLen -= 1;
            start++;
        }
        currentWordSet.add(s.charAt(end));
        currentLen+=1;
        end++;
        System.out.println(currentWordSet);
    }
    return Math.max(maxLen, currentLen);

}
