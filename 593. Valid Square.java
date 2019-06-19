class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isValidSquare(p1,p2,p3,p4) ||
            isValidSquare(p1,p3,p2,p4) ||
            isValidSquare(p1,p2,p4,p3);
    }

    private int calcLength(int[] a, int[] b) {
        return (int)Math.pow(a[0]-b[0],2) + (int)Math.pow(a[1]-b[1], 2);
    }

    private boolean isValidSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return calcLength(p1,p2) > 0 &&
            calcLength(p1,p2) == calcLength(p2,p3) &&
            calcLength(p2,p3) == calcLength(p3,p4) &&
            calcLength(p3,p4) == calcLength(p4,p1) &&
            calcLength(p1,p3) == calcLength(p2,p4);
    }
}
