class Solution {
    
    /**
    Idea is to reverse the string and find the common substring. 
    And remaning string from the reversed will be the string that needs to be added in front
    */
    
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
    	for (int i = 0; i < s.length(); i++) 
    		if (rev.substring(i).equals(s.substring(0, s.length() - i))) 
    			return rev.substring(0, i) + s;
    	
    	return s;
    }
}