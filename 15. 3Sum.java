class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> retval = new ArrayList<>();
        
        Set<List<Integer>> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            
            int start = 0, end  = nums.length - 1;
            int target = -1 * nums[i];
            while(start < end) {

                if (start == i) {
                    start++; continue;
                } 
                
                if (end == i){
                    end--; continue;
                }
                
                if (nums[start] + nums[end] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[start]);
                    list.add(nums[end]);
                    list.add(nums[i]);
                    Collections.sort(list);
                    set.add(list);
                    start++;
                    end--;
                    continue;
                }
                
                if (nums[start] + nums[end] < target) start++;
                if (nums[start] + nums[end] > target) end--;
            }
        }
    
        return new ArrayList<>(set);
    }
}