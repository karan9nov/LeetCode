class Solution {

    public int change(int amount, int[] coins) {

        if ((coins == null || coins.length == 0) && amount == 0) return 1;
        if (coins == null || coins.length == 0) return 0;
        if (amount == 0) return 1;


        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i <= amount; i++) {
            if (i >= coins[0] && i % coins[0] == 0) dp[0][i] = 1;
            // System.out.print(dp[0][i] + ", ");
        }

        for (int i = 1; i < coins.length; i++) {
            // System.out.println();
            for (int j = 0; j < dp[i].length; j++) {
                if (j == 0) dp[i][j] = 1;
                else if (j < coins[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j - coins[i]];
                // System.out.print(dp[i][j] + ", ");
            }
        }

        return dp[coins.length - 1][amount];

    }

    /* This method is using recursion but it exceeds the time

    static int ways = 0;

    public int change(int amount, int[] coins) {

        changeHelper(amount, coins);
        return ways;

    }

    private void changeHelper(int amount, int[] coins) {

        if (amount == 0) {
            ways = ways + 1;
            return;
        }

        if (amount < 0 || coins.length == 0)
            return;

        changeHelper(amount, Arrays.copyOfRange(coins, 1, coins.length));
        changeHelper(amount - coins[0], coins);

    }

    */


}
