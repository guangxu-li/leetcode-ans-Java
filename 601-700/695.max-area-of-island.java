/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    private boolean[][] visited;
    private int[][] grid;

    private int dfs(int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        return 1 + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.visited = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || visited[i][j]) {
                    continue;
                }

                maxArea = Math.max(maxArea, dfs(i, j));
            }
        }

        return maxArea;
    }
}
// @lc code=end

