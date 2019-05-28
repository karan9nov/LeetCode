/*
TIME LIMIT EXCEEDED
*/

class Solution {
    public boolean canPartition(int[] nums) {

        int totalSum = 0;

        for (int num: nums)
            totalSum += num;

        if (totalSum % 2 != 0) return false;

        return canPartition(nums, new boolean[nums.length], 0, 2, 0, totalSum / 2);
    }

    private boolean canPartition(int[] nums, boolean[] used, int start, int k, int currentSum, int targetSum) {

        // k == 1 this means that we have already formed k-1 buckets. and since the sum was properly divisible
        // so the last kth bucket would also be formed properly.
        if (k == 1) return true;

        // it target sum = current sum, this means we were able to form a bucket succesfully
        // now we should be able to form more buckets as well.
        // basically starting again, but with one less k. and keeping the used array as same.
        if (targetSum == currentSum)
            return canPartition(nums, used, 0, k-1, 0, targetSum);

        // this means that we have still not found the bucket we were looking for and we continue to find it.
        for (int i = start; i < nums.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                if (canPartition(nums, used, i+1, k, currentSum + nums[i], targetSum)){
                    return true;
                } else {
                    used[i] = false;
                }
            }
        }

        return false;

    }
}
