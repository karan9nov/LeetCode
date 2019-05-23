class Solution {
    public int findLength(int[] A, int[] B) {

        int ans = 0;

        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                    ans = Math.max(ans, dp[i+1][j+1]);
                }
            }
        }

        /*
         * So basically if we see one common number, then we add 1 to the previous common count.
         */

        return ans;
    }
}
