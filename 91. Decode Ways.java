class Solution {
    
    // int numWays;
    
    public int numDecodings(String s) {
        
        int[] arr = new int[s.length()];
        Arrays.fill(arr, -1);
        return numDecodings(s, 0, arr);
    }    
    
    
    private int numDecodings(String s, int start, int[] arr) {
        
        if(start == s.length()) return 1;
        if (arr[start] != -1) return arr[start];
        if (s.charAt(start) == '0') return 0;
        
        int oneChar = numDecodings(s, start + 1, arr);
        
        int twoChar = 0;
        if (start <= s.length() - 2 && Integer.parseInt(s.substring(start, start + 2)) <= 26)
            twoChar = numDecodings(s, start+2, arr);
        
        arr[start] = oneChar+twoChar;
        return oneChar+twoChar;
    }
}