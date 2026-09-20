class MedianFinder {
    private PriorityQueue<Integer> leftHalfPq;
    private PriorityQueue<Integer> rightHalfPq;

    public MedianFinder() {
        leftHalfPq = new PriorityQueue<>(Collections.reverseOrder());
        rightHalfPq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        leftHalfPq.add(num);
        if (!leftHalfPq.isEmpty() && !rightHalfPq.isEmpty()
            && leftHalfPq.peek() > rightHalfPq.peek())
            rightHalfPq.offer(leftHalfPq.poll());
        if (leftHalfPq.size() > rightHalfPq.size() + 1)
            rightHalfPq.offer(leftHalfPq.poll());
        else if (rightHalfPq.size() > leftHalfPq.size()) {
            leftHalfPq.offer(rightHalfPq.poll());
        }
    }

    public double findMedian() {
        // if odd number of elts, then the left half will have the median
        if (leftHalfPq.size() > rightHalfPq.size())
            return leftHalfPq.peek();
        else
            return (double) (leftHalfPq.peek() + rightHalfPq.peek()) / 2;
    }
}
