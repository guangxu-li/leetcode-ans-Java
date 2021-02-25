/*
 * @lc app=leetcode id=490 lang=java
 *
 * [490] The Maze
 */

// @lc code=start
class Solution {
    private int[][] maze;
    private int m;
    private int n;
    private int[] dest;
    private boolean[][] visited;

    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean canPass(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0;
    }

    private boolean canReach(int x, int y) {
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;

        if (x == dest[0] && y == dest[1]) {
            return true;
        }

        for (int[] dir : dirs) {
            int i = x;
            int j = y;
            while (canPass(i + dir[0], j + dir[1])) {
                i += dir[0];
                j += dir[1];
            }

            if (canReach(i, j)) {
                return true;
            }
        }

        return false;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.m = maze.length;
        this.n = m == 0 ? 0 : maze[0].length;
        this.dest = destination;
        this.visited = new boolean[m][n];

        return canReach(start[0], start[1]);
    }
}
// @lc code=end

