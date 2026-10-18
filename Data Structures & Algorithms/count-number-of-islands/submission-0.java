class Solution {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    traverse(i, j, grid);
                }
            }
        }
        return numberOfIslands;
    }
    public void traverse(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] != '1')
            return;
        grid[i][j] = '#';
        traverse(i + 1, j, grid);
        traverse(i - 1, j, grid);
        traverse(i, j + 1, grid);
        traverse(i, j - 1, grid);
    }
}
