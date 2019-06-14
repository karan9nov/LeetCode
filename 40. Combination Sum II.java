class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Set<List<Integer>> retval = new HashSet<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<Integer>(), retval);
        return new ArrayList<>(retval);

    }

    private void combinationSum(int[] nums, int target, int currentSum, List<Integer> currentList, Set<List<Integer>> retval) {

        if (currentSum == target) {
            retval.add(new ArrayList<>(currentList));
            return;
        }

        if (nums.length == 0 || currentSum > target) {
            return;
        }


        combinationSum(Arrays.copyOfRange(nums, 1, nums.length), target, currentSum, new ArrayList<>(currentList), retval);
        currentList.add(nums[0]);
        combinationSum(Arrays.copyOfRange(nums, 1, nums.length), target, currentSum + nums[0], new ArrayList<>(currentList), retval);
    }
}
