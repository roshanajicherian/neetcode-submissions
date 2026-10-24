class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currentArea = areaCalc(grid, i, j);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    public int areaCalc(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;
        if (grid[i][j] != 1)
            return 0;
        grid[i][j] = -1;
        int res = 1;
        res = res + areaCalc(grid, i + 1, j) + areaCalc(grid, i - 1, j) + areaCalc(grid, i, j + 1)
            + areaCalc(grid, i, j - 1);
        return res;
    }
}
