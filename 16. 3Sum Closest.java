class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int sum = 0;
        int minDiff = Integer.MAX_VALUE;
        int returnSum = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 ; i++){

            int twoSum = twoSumClosest(nums, target - nums[i], i+1, nums.length - 1);
            sum = nums[i] + twoSum;

            if (minDiff > Math.abs(sum - target)){
                minDiff = Math.abs(sum-target);
                returnSum = sum;
            }

        }

        return returnSum;
    }

    public int twoSumClosest(int[] nums, int target, int l, int r){
        /**
         * For a sorted array
         */
//        System.out.println(l);
//        System.out.println(r);
        int minDiff = Integer.MAX_VALUE;
        int sum = nums[l] + nums[r];
        int returnSum = sum;

        while( l < r){

            sum = nums[l] + nums[r];
            if (minDiff > Math.abs(target - sum)){
                returnSum = sum;
                minDiff = Math.abs(target - sum);
            }


            if(sum < target) l++;
            else r--;
        }
        return returnSum;
    }
}
