class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++)
            for (int j = 1; j < m; j++)
                dp[j] = dp[j] + dp[j-1];

        return dp[m-1];
    }
}
