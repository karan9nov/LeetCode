class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return intervals;

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        };

        Arrays.sort(intervals, comparator);

        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval: intervals) {
            if (interval[0] <= end) {
                if (interval[1] > end) end = interval[1];
            } else {
                list.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        list.add(new int[]{start, end});

        int[][] retval = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            retval[i] = list.get(i);
        }

        return retval;
    }
}
