class Solution {
    public int lengthOfLIS(int[] nums) {
        /* https://www.youtube.com/watch?v=CE2b_-XfVDk */

        if (nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        dp[0]=1;
        int retval = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    retval = Math.max(retval, dp[i]);
                }
            }
            // for (int x:dp) System.out.print(x + ",");
            // System.out.println();
        }

        return retval;
    }
}
