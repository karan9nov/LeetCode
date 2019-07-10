class Solution {
    public int minMeetingRooms(int[][] intervals) {
		
		Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        };

        Arrays.sort(intervals, comparator);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // minHeap.offer(intervals[0][1]);
        for (int i = 0; i < intervals.length; i++) {
        	if (!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()) {
        		minHeap.poll();
        	}
        	minHeap.offer(intervals[i][1]);
            System.out.println(minHeap);
        }
        
        return minHeap.size();

    }
}