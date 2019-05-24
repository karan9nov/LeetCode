class Solution {
    public void sortColors(int[] nums) {

        int zero = 0;
        int two = nums.length - 1;

        int i = 0;
        while (i <= two) {

            if (nums[i] == 2) {
                // swap two and i
                swap(nums, two, i);
                // decremnet two
                two--;
            } else if (nums[i] == 0) {
                // swap zero and i
                swap(nums, zero, i);
                // increment zero and i
                i++;
                zero++;
            } else {
                // increment i
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
