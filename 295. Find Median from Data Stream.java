class MedianFinder {

    PriorityQueue<Integer> lowers, highers;

    /** initialize your data structure here. */
    public MedianFinder() {
        lowers = new PriorityQueue<>(Collections.reverseOrder());
        highers = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (lowers.size() == 0 || num < lowers.peek()) {
            lowers.offer(num);
        } else {
            highers.offer(num);
        }

        if (lowers.size() - highers.size() > 1) {
            highers.offer(lowers.poll());
        } else if (highers.size() - lowers.size() > 1){
            lowers.offer(highers.poll());
        }

    }

    public double findMedian() {
        if (lowers.size() == highers.size())
            return (lowers.peek() + highers.peek())/2.0;
        else if (lowers.size() > highers.size())
            return lowers.peek();
        else
            return highers.peek();
    }

}
