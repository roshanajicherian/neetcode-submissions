class Solution {
    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        Comparator<Pair> cp = (p1, p2) -> {
            int p1DistSq = p1.x * p1.x + p1.y * p1.y;
            int p2DistSq = p2.x * p2.x + p2.y * p2.y;
            return Integer.compare(p2DistSq, p1DistSq);
        };
        PriorityQueue<Pair> pq = new PriorityQueue<>(cp);
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            Pair p = new Pair(x, y);
            pq.offer(p);
            if (pq.size() > k)
                pq.poll();
        }
        int[][] resArray = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair res = pq.poll();
            resArray[i][0] = res.x;
            resArray[i][1] = res.y;
        }
        return resArray;
    }
}
