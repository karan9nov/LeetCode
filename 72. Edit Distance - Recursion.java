class Solution {
    public int minDistance(String word1, String word2) {
        
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        
        if (word1.charAt(0) == word2.charAt(0)) 
            return minDistance(word1.substring(1), word2.substring(1)); 
        
        return 1 + Math.min(
                            minDistance(word1.substring(1), word2.substring(1)),
                            Math.min(
                                minDistance(word1.substring(1), word2),
                                minDistance(word1, word2.substring(1))
                            )
        );
    }
}