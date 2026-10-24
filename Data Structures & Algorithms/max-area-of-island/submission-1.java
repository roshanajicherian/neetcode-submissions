class Solution {
    public int maxArea;
    public int currentArea;

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    currentArea = 0;
                    areaCalc(grid, i, j);
                    maxArea = Math.max(currentArea, maxArea);

                }
            }
        }
        return maxArea;
    }

    public void areaCalc(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;
        if (grid[i][j] != 1)
            return;
        currentArea++;
        grid[i][j] = -1;
        areaCalc(grid, i + 1, j);
        areaCalc(grid, i - 1, j);
        areaCalc(grid, i, j + 1);
        areaCalc(grid, i, j - 1);
    }
}
