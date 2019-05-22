class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;

        int total = x + y;

        int start = 0;
        int end = x;
        int parX = (start + end) / 2;
        int parY = (x + y + 1) / 2 - parX;

        while (start <= end) {

            int maxLeftX = parX == 0 ? Integer.MIN_VALUE : nums1[parX - 1];
            int maxLeftY = parY == 0 ? Integer.MIN_VALUE : nums2[parY - 1];
            int minRightX = parX == x ? Integer.MAX_VALUE : nums1[parX];
            int minRightY = parY == y ? Integer.MAX_VALUE : nums2[parY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

                if (total % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }

            } else if (maxLeftX > minRightY) {
                end = parX - 1;
                parX = (start + end) / 2;
                parY = (x + y + 1) / 2 - parX;
            } else {
                start = parX + 1;
                parX = (start + end) / 2;
                parY = (x + y + 1) / 2 - parX;
            }

        }

        return -1;
    }
}
