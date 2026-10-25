class Solution {
    public static class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        // Atlantic
        for (int j = 0; j < m; j++) {
            queue.add(new Pair(n - 1, j));
            atlantic[n - 1][j] = true;
        }
        for (int i = 0; i < n; i++) {
            queue.add(new Pair(i, m - 1));
            atlantic[i][m - 1] = true;
        }
        traverse(heights, queue, atlantic, n, m);
        // Pacific
        for (int j = 0; j < m; j++) {
            queue.add(new Pair(0, j));
            pacific[0][j] = true;
        }
        for (int i = 0; i < n; i++) {
            queue.add(new Pair(i, 0));
            pacific[i][0] = true;
        }
        traverse(heights, queue, pacific, n, m);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(new ArrayList<>(List.of(i, j)));
            }
        }
        return result;
    }
    public void traverse(int[][] heights, Queue<Pair> queue, boolean[][] visited, int n, int m) {
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int i = p.i;
            int j = p.j;
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (heights[nr][nc] >= heights[i][j]) {
                    visited[nr][nc] = true;
                    queue.add(new Pair(nr, nc));
                }
            }
        }
    }
}
