class Solution {

    public int search(int[] nums, int target) {

        int rotatingPoint = findRotatingPoint(nums, 0, nums.length - 1);
        System.out.println(rotatingPoint);
        int left = binarySearch(nums, target, 0, rotatingPoint);
        if (left != -1) return left;
        return binarySearch(nums, target, rotatingPoint + 1, nums.length - 1);
    }

    private int findRotatingPoint(int[] nums, int start, int end) {

        if (start <= end) {

            int mid = (start + end)/2;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            } else {
                if (nums[mid] < nums[start]){
                    return findRotatingPoint(nums, start, mid-1);
                } else {
                    return findRotatingPoint(nums, mid+1, end);
                }
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start <= end) {
            int mid = (start+ end) / 2;
            if (nums[mid] == target) return mid;
            if (target < nums[mid]) {
                return binarySearch(nums, target, start, mid-1);
            } else {
                return binarySearch(nums, target, mid+1, end);
            }
        }
        return -1;
    }
}
