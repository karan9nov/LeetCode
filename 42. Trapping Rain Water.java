class Solution {
    public int trap(int[] height) {
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			if (height[i] >= max) 
				max = height[i];
			else 
				left[i] = max - height[i];
		}
        
		max = 0;
		for (int i = height.length - 1; i >= 0; i--) {
			if (height[i] >= max) 
				max = height[i];
			else 
				right[i] = max - height[i];
		}
		
		int retval = 0;
		for (int i = 0; i < height.length; i++) {
			retval += Math.min(left[i], right[i]);
		}
		return retval;
	}
}