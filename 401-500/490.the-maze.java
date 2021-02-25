import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=490 lang=java
 *
 * [490] The Maze
 */

// @lc code=start
class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean canPass(int[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        return x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(start[0]);
        nodes.add(start[1]);
        boolean[][] visited = new boolean[m][n];

        while (!nodes.isEmpty()) {
            int x = nodes.poll();
            int y = nodes.poll();

            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;

            if (x == destination[0] && y == destination[1]) {
                return true;
            }

            for (int[] dir : dirs) {
                int i = x;
                int j = y;
                while (canPass(maze, i + dir[0], j + dir[1])) {
                    i += dir[0];
                    j += dir[1];
                }

                nodes.add(i);
                nodes.add(j);
            }
        }

        return false;
    }
}
// @lc code=end

