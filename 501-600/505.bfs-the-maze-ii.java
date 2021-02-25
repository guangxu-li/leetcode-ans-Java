import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=505 lang=java
 *
 * [505] The Maze II
 */

// @lc code=start
class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean canPass(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Integer[][] dist = new Integer[maze.length][maze[0].length];
        dist[start[0]][start[1]] = 0;
        Queue<int[]> nodes = new LinkedList<>();
        nodes.add(start);

        while (!nodes.isEmpty()) {
            int[] node = nodes.poll();

            for (int[] dir : dirs) {
                int i = node[0];
                int j = node[1];
                int cnt = 0;
                while (canPass(maze, i + dir[0], j + dir[1])) {
                    i += dir[0];
                    j += dir[1];
                    cnt++;
                }

                if (dist[i][j] == null || dist[node[0]][node[1]] + cnt < dist[i][j]) {
                    dist[i][j] = dist[node[0]][node[1]] + cnt;
                    nodes.add(new int[] {i, j});
                }
            }
        }

        return dist[destination[0]][destination[1]] == null ? -1
                : dist[destination[0]][destination[1]];
    }
}
// @lc code=end

