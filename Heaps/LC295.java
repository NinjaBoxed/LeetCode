class LC295 {

    /** initialize your data structure here. */
    private Queue<Integer> maxQueue = new PriorityQueue<>(20, Collections.reverseOrder());
    private Queue<Integer> minQueue = new PriorityQueue<>();
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        // add to maxQueue
        maxQueue.add(num);
        
        // make sure minQueue always has elements bigger than maxQueue by adding max
        // value from maxQueue to minQueue, we add the max to minQueue
        minQueue.add(maxQueue.peek());
        maxQueue.poll();
        
        // to make sure queue sizes are same while still values in minQueue are higher than
        // values in maxQueue, we add the min to maxQueue
        if(maxQueue.size() > minQueue.size()) {
            maxQueue.add(minQueue.peek());
            minQueue.poll();
        }
    }
    
    public double findMedian() {
        return maxQueue.size() == minQueue.size() ? (maxQueue.peek() + minQueue.peek()) / 2 : maxQueue.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */