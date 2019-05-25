class Solution {
    public int findPeakElement(int[] nums) {

        return findPeakElement(nums, 0, nums.length - 1);

    }

    private int findPeakElement(int[] nums, int left, int right) {

        if (left == right) return left;

        int mid = (left + right) / 2;

        if (nums[mid + 1] > nums[mid])
            return findPeakElement(nums, mid + 1, right);
        else
            return findPeakElement(nums, left, mid);
    }
}
