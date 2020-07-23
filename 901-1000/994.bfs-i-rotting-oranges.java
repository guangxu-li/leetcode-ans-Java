import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=994 lang=java
 *
 * [994] Rotting Oranges
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        Queue<Integer> indices = new ArrayDeque<Integer>();
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    num++;
                } else if (grid[i][j] == 2) {
                    indices.add(i);
                    indices.add(j);
                }
            }
        }

        int timer = 0;
        while (!indices.isEmpty() && num > 0) {
            int size = indices.size() / 2;

            while (size-- > 0) {
                int i = indices.poll();
                int j = indices.poll();

                if (i != grid.length - 1 && grid[i + 1][j] == 1) {
                    num--;

                    grid[i + 1][j] = 2;
                    indices.add(i + 1);
                    indices.add(j);
                }

                if (i != 0 && grid[i - 1][j] == 1) {
                    num--;

                    grid[i - 1][j] = 2;
                    indices.add(i - 1);
                    indices.add(j);
                }

                if (j != grid[0].length - 1 && grid[i][j + 1] == 1) {
                    num--;

                    grid[i][j + 1] = 2;
                    indices.add(i);
                    indices.add(j + 1);
                }

                if (j != 0 && grid[i][j - 1] == 1) {
                    num--;

                    grid[i][j - 1] = 2;
                    indices.add(i);
                    indices.add(j - 1);
                }
            }

            timer++;
        }

        if (num != 0) {
            return -1;
        } else {
            return timer;
        }
    }
}
// @lc code=end

