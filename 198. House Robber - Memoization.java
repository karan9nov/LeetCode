class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
    	return Math.max(rob(nums, 0, memo), rob(nums, 1, memo));
    }
    
    private int rob(int[] nums, int index, Integer[] memo) {
    	
    	if (nums.length == 0 || index >= nums.length) 
    		return 0;
    	if (nums.length - 1 == index)
    		return nums[index];
    	
        if (memo[index] != null) 
            return memo[index];
        
    	memo[index] = Math.max(
	    			nums[index] + rob(nums, index + 2, memo),
	    			nums[index] + rob(nums, index + 3, memo) 
    			);
    	
        return memo[index];
    }
}