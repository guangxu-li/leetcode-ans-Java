import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private void bfs(char[][] grid, int i, int j) {
        Queue<Integer> indices = new LinkedList<>();
        indices.add(i);
        indices.add(j);

        while (!indices.isEmpty()) {
            int x = indices.poll();
            int y = indices.poll();

            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
                continue;
            }

            grid[x][y] = '0';
            // 1. up 2. down 3.left 4. right
            indices.add(x - 1);
            indices.add(y);

            indices.add(x + 1);
            indices.add(y);

            indices.add(x);
            indices.add(y - 1);

            indices.add(x);
            indices.add(y + 1);
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    num++;
                }
            }
        }

        return num;
    }
}
// @lc code=end

