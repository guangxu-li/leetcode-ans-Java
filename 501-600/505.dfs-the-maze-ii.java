/*
 * @lc app=leetcode id=505 lang=java
 *
 * [505] The Maze II
 */

// @lc code=start
class Solution {
    private Integer[][] dist;
    private int[][] maze;
    private int[] dest;
    private int m;
    private int n;

    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0;
    }

    private void move(int x, int y) {
        if (x == dest[0] && y == dest[1]) {
            return;
        }

        for (int[] dir : dirs) {
            int i = x;
            int j = y;
            int cnt = 0;

            while (isValid(i + dir[0], j + dir[1])) {
                i += dir[0];
                j += dir[1];
                cnt++;
            }

            if (dist[i][j] == null || dist[x][y] + cnt < dist[i][j]) {
                dist[i][j] = dist[x][y] + cnt;
                move(i, j);
            }
        }
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.m = maze.length;
        this.n = maze[0].length;
        this.dist = new Integer[m][n];
        this.dest = destination;

        dist[start[0]][start[1]] = 0;

        move(start[0], start[1]);

        return dist[dest[0]][dest[1]] == null ? -1 : dist[dest[0]][dest[1]];
    }
}
// @lc code=end

