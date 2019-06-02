class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n][n];

        for (int i = n-1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (i == n-1) {
                    dp[i][j] = list.get(j);
                    continue;
                }
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + list.get(j);
            }
        }

        return dp[0][0];
    }
}

/**

Bottom up approach

  | 0 | 1 | 2 | 3 |
--|---|---|---|---|
0 | 11| x | x | x |
--|---|---|---|---|
1 | 9 | 10| x | x |
--|---|---|---|---|
2 | 7 | 6 | 10| x |
--|---|---|---|---|
3 | 4 | 1 | 8 | 3 |
--|---|---|---|---|

*/
