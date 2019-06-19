/**
Inspired by: https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
*/
class Solution {
    public int rob(int[] nums) {
        
        int curr = 0, prev = 0;
        
        for (int x: nums) {
            int temp = Math.max(curr, prev + x);
            prev = curr; 
            curr = temp;
        }
        
        return curr;
    }
}