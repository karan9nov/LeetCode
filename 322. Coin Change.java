class Solution {
    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        Arrays.fill(dp[0], Integer.MAX_VALUE - 1);
        for (int i = 0; i <= amount; i++) {
            if (i == 0) dp[0][i] = 0;
            if (i >= coins[0] && i % coins[0] == 0) dp[0][i] = i / coins[0];
            // System.out.print(dp[0][i] + ", ");
        }


        for(int i = 1; i < dp.length; i++) {
            // System.out.println();
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
            for (int j = 0; j < dp[0].length; j++) {
                if(j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j < coins[i]) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i]]);
                // System.out.print(dp[i][j] + ", ");
            }
        }

        return dp[coins.length - 1][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[coins.length - 1][amount];
    }
}
