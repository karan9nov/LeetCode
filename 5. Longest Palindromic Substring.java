class Solution {
    
    public String longestPalindrome(String s) {
        
        if (s.length() == 0 || s.length() == 1) return s;
        
        String retval = "";
        
        for (int i = 0; i < s.length() - 1; i++) {
            String temp = checkPalidrome(s, i, i);
            if (temp.length() > retval.length()) retval = temp;
            temp = checkPalidrome(s, i, i+1);
            if (temp.length() > retval.length()) retval = temp;
        }
        
        return retval;
        
    }
    
    private String checkPalidrome(String s, int start, int end) {
        
        int leftStart = start;
        int rightStart = end;
        
        while (start > 0 && end < s.length()-1 && s.charAt(start) == s.charAt(end)) {
            start--;end++;
        }
        
        if (s.charAt(start) == s.charAt(end)) return s.substring(start, end + 1);
        else return s.substring(start+1, end);
    }
}