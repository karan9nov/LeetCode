class Solution {
    public int lenLongestFibSubseq(int[] A) {

        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++)
            map.put(A[i], i);

        for(int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                int len = findLen(A, i, j, map);
                max = Math.max(len, max);
            }
        }

        return max < 3? 0 :max;
    }

    private int findLen(int[] A, int i, int j, Map<Integer, Integer> map) {

        int first = i, second = j, len = 2;

        while (map.containsKey(A[first] + A[second])) {
            // System.out.print("(" + A[first] + "," + A[second] + ") ->");
            int tempIndex = map.get(A[first] + A[second]);
            first = second;
            second = tempIndex;
            len += 1;
        }

        // System.out.println("(" + A[first] + "," + A[second] + ")");

        return len;
    }
}
