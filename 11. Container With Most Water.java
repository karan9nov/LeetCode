class Solution {
    public int maxArea(int[] arr) {

        int l = 0, r = arr.length - 1, maxarea = 0;

        while (l < r){
            maxarea = Math.max(maxarea, Math.min(arr[l], arr[r]) * (r - l));
            if (arr[l] < arr[r])
                l++;
            else
                r--;
        }

        return maxarea;

    }
}
