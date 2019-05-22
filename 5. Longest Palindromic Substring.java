class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.trim().length() == 0)
            return s;

        int start = 0, end = 0;
        String maxStr = "";

        for (int i = 0; i < s.length(); i++) {

            // with odd length
            int oddLen = expandAroundCenter(s, i, i);
            // with even length
            int evenLen = expandAroundCenter(s, i, i+1);
            // find the max of odd and even lengths
            int tempLen = Math.max(oddLen, evenLen);

            if (tempLen > end - start) {
                start = i - (tempLen - 1) / 2;
                end = i + tempLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}
