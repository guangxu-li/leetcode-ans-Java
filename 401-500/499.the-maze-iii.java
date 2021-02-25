import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=499 lang=java
 *
 * [499] The Maze III
 */

// @lc code=start
class Node {
    public int x;
    public int y;
    public int distance;
    public StringBuilder path;

    public Node(int x, int y, int distance, StringBuilder path) {
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.path = path;
    }
}

class Solution {

    private static final int[][] dirs = new int[][] {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    private static final char[] parseDir = new char[] {'d', 'l', 'r', 'u'};

    private boolean canPass(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0;
    }

    /*
     * For multiple shortest ways, only output lexicographically smallest way
     * down < left < right < up
     */
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] dist = new int[maze.length][maze[0].length];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[ball[0]][ball[1]] = 0;

        Queue<Node> nodes = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        nodes.add(new Node(ball[0], ball[1], 0, new StringBuilder()));
        String path = "";

        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (node.x == hole[0] && node.y == hole[1]) {
                String candidate = node.path.toString();
                if (path.isEmpty() || path.compareTo(candidate) > 0) {
                    path = candidate;
                }

                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int[] dir = dirs[i];
                char d = parseDir[i];

                int x = node.x;
                int y = node.y;
                
                int cnt = 0;
                while (canPass(maze, x + dir[0], y + dir[1])) {
                    x += dir[0];
                    y += dir[1];
                    cnt++;

                    if (x == hole[0] && y == hole[1]) {
                        break;
                    }
                }

                if (cnt == 0) {
                    continue;
                }

                if (dist[node.x][node.y] + cnt <= dist[x][y]) {
                    dist[x][y] = dist[node.x][node.y] + cnt;
                    nodes.add(new Node(x, y, dist[x][y], new StringBuilder(node.path).append(d)));
                }
            }
        }

        return path.isEmpty() ? "impossible" : path;
    }
}
// @lc code=end

