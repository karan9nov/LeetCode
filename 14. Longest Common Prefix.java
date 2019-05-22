class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        if (strs.length > 0)
            sb.append(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];

            int j = 0;
            for (; j < s.length() && j < sb.length(); j++) {
                if (s.charAt(j) != sb.charAt(j)) {
                    sb = new StringBuilder(sb.substring(0, j));
                    break;
                }
            }

            if (j == s.length() && s.length() < sb.length()) {
                sb = new StringBuilder(s.substring(0,j));
            }
        }
        return sb.toString();
    }
}
