class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retval = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), retval);
        return retval;
    }

    private void combinationSum(int[] nums, int target, List<Integer> currentList, List<List<Integer>> retval) {

        if (target == 0) {
            retval.add(new ArrayList<>(currentList));
            return;
        }

        if (target < 0 || nums.length == 0)
            return;

        combinationSum(Arrays.copyOfRange(nums, 1, nums.length), target, new ArrayList<>(currentList), retval);
        currentList.add(nums[0]);
        combinationSum(nums, target - nums[0], new ArrayList<>(currentList), retval);
    }
}
