class Solution {
    public static class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                bfs(board, i, 0);
            if (board[i][m - 1] == 'O')
                bfs(board, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                bfs(board, 0, j);
            if (board[n - 1][j] == 'O')
                bfs(board, n - 1, j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void bfs(char[][] board, int r, int c) {
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(r, c));
        board[r][c] = 'E';

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            int cr = curr.i;
            int cc = curr.j;

            for (int[] dir : directions) {
                int nr = cr + dir[0];
                int nc = cc + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 'O') {
                    board[nr][nc] = 'E';
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
    }
}
