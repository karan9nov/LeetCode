class Solution {
    public boolean canAttendMeetings(int[][] intervals) {

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        };

        Arrays.sort(intervals, comparator);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i+1][0])
                return false;
        }

        return true;
    }
}
