class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<List<Integer>> retval = new HashSet<>();
        findSubsequences(nums, 0, retval);

        List<List<Integer>> finalList = new ArrayList<>(retval);
        for (int i = 0; i < finalList.size(); i++) {
            if (finalList.get(i).size() == 1) {
                finalList.remove(i);
                i--;
            }
        }

        return finalList;
    }

    private Set<List<Integer>> findSubsequences(int[] nums, int i, Set<List<Integer>> retval) {

        if (i == nums.length) {
            return retval;
        }

        retval = findSubsequences(nums, i+1, retval);

        Set<List<Integer>> tempList = new HashSet<>();

        for (List<Integer> list: retval) {
            if (list.get(0) >= nums[i]){
                List<Integer> someList = new ArrayList<>(list);
                someList.add(0, nums[i]);
                tempList.add(someList);
            }
        }

        List<Integer> oneElementList = new ArrayList<>();
        oneElementList.add(nums[i]);
        retval.add(oneElementList);


        retval.addAll(tempList);
        return retval;
    }
}
