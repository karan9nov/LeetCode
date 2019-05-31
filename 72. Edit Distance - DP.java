class Solution {
    public int minDistance(String word1, String word2) {
        
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i < dp.length; i++) {
            // if (i == 0) System.out.print("\t");
            // if(i != 0) System.out.print(word1.charAt(i-1) + "\t|");
            for (int j = 0; j < dp[0].length; j++) {
                
                if (i == 0) {
                    dp[i][j] = j; 
                    // System.out.print(dp[i][j] + ",\t");
                    continue;
                }
                
                if (j == 0) {
                    dp[i][j] = i;
                    // System.out.print(dp[i][j] + ",\t");
                    continue;
                }
                
                int min = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = min + 1;
                
                // System.out.print(dp[i][j] + ",\t");
            }
            // System.out.println();
        }
        
        return dp[word1.length()][word2.length()];
    }
}