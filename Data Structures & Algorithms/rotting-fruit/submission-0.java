class Solution {
    public static class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> mainQueue = new LinkedList<>();
        Queue<Pair> surroundingQueue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    mainQueue.offer(new Pair(i, j));
                } else if (grid[i][j] == 1)
                    freshCount++;
            }
        }
        if (freshCount == 0)
            return 0;

        int timer = 0;
        while (!mainQueue.isEmpty()) {
            Pair p = mainQueue.poll();
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                int ni = p.i + dir[0];
                int nj = p.j + dir[1];
                if (ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length)
                    continue;
                if (grid[ni][nj] == 1) {
                    freshCount--;
                    grid[ni][nj] = 2;
                    surroundingQueue.offer(new Pair(ni, nj));
                }
            }
            if (mainQueue.isEmpty() && !surroundingQueue.isEmpty()) {
                timer++;
                mainQueue.addAll(surroundingQueue);
                surroundingQueue.clear();
            }
        }

        return freshCount == 0 ? timer : -1;
    }
}
