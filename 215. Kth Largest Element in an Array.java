class Solution {
    public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int x: nums)
			maxHeap.offer(x);
		
		int i = 1;
		while (i != k) {
			maxHeap.poll();
            i++;
		}
		
		return maxHeap.peek();
    }
}