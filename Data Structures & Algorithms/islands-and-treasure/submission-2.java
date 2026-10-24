class Solution {
    public class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Pair p = new Pair(i, j);
                    queue.add(p);
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            processSurrounding(p.i, p.j, grid, queue);
        }
    }

    public void processSurrounding(int i, int j, int[][] grid, Queue<Pair> queue) {
        int currentDistance = grid[i][j];
        if (i - 1 >= 0 && grid[i - 1][j] == Integer.MAX_VALUE) {
            queue.offer(new Pair(i - 1, j));
            grid[i - 1][j] = currentDistance + 1;
        }
        if (i + 1 < grid.length && grid[i + 1][j] == Integer.MAX_VALUE) {
            queue.offer(new Pair(i + 1, j));
            grid[i + 1][j] = currentDistance + 1;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == Integer.MAX_VALUE) {
            queue.offer(new Pair(i, j - 1));
            grid[i][j - 1] = currentDistance + 1;
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == Integer.MAX_VALUE) {
            queue.offer(new Pair(i, j + 1));
            grid[i][j + 1] = currentDistance + 1;
        }
    }
}
