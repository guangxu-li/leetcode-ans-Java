/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int timer = 2;
        int num = 0;

        for (int[] row : grid) {
            for (int n : row) {
                if (n == 1) {
                    num++;
                }
            }
        }

        boolean finished = false;

        while (num > 0 && !finished) {
            finished = true;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != timer) {
                        continue;
                    }

                    if (i != 0 && grid[i - 1][j] == 1) {
                        num--;
                        grid[i - 1][j] = timer + 1;
                        finished = false;
                    }

                    if (i != grid.length - 1 && grid[i + 1][j] == 1) {
                        num--;
                        grid[i + 1][j] = timer + 1;
                        finished = false;
                    }

                    if (j != 0 && grid[i][j - 1] == 1) {
                        num--;
                        grid[i][j - 1] = timer + 1;
                        finished = false;
                    }

                    if (j != grid[0].length - 1 && grid[i][j + 1] == 1) {
                        num--;
                        grid[i][j + 1] = timer + 1;
                        finished = false;
                    }
                }
            }

            timer++;
        }

        return num > 0 ? -1 : timer - 2;
    }
}
// @lc code=end

