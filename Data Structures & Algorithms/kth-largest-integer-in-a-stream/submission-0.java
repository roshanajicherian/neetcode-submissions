class KthLargest {
    public PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int x : nums) {
            add(x);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k)
            pq.poll();
        if (!pq.isEmpty())
            return pq.peek();
        return -1;
    }
}
