class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> retval = new ArrayList<>();
        
        if (matrix.length == 0) return retval;
        
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        
        while (r1 <= r2 && c1 <= c2) {
            
            // System.out.println(r1 + "," + r2);
            // System.out.println(c1 + "," + c2);
            
            for (int i = c1; i <= c2; i++) retval.add(matrix[r1][i]);
            r1+=1;
            // System.out.println(retval);
            for (int i = r1; i <= r2; i++) retval.add(matrix[i][c2]);
            // System.out.println(retval);
            c2-=1;
            
            // System.out.println(r1 + "," + r2);
            // System.out.println(c1 + "," + c2);
            if (c1 <= c2 && r1 <= r2) {
                for (int i = c2; i >= c1; i--) retval.add(matrix[r2][i]);
                // System.out.println(retval);
                r2-=1;
                for (int i = r2; i >= r1; i--) retval.add(matrix[i][c1]);
                // System.out.println(retval);
                c1+=1;
            }
        }
        
        return retval;
    }
}