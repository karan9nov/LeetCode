class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.offer(matrix[i][j]);
            }
        }
        
        // System.out.println(queue);
        
        int retval = -1;
        while (k!=0) {
            retval = queue.poll();
            // System.out.println(retval);
            k--;
        }
        
        return retval;
    }
}