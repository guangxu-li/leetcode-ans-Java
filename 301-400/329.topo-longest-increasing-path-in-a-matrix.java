import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=329 lang=java
 *
 * [329] Longest Increasing Path in a Matrix
 */

// @lc code=start
class Solution {
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean isValid(int i, int j, int m, int n) {
        return !(i < 0 || i == m || j < 0 || j == n);
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] out = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (isValid(ni, nj, m, n) && matrix[i][j] < matrix[ni][nj]) {
                        out[i][j]++;
                    }
                }
            }
        }

        Queue<Integer> nodes = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (out[i][j] == 0) {
                    nodes.add(i);
                    nodes.add(j);
                }
            }
        }

        int len = 0;
        while (!nodes.isEmpty()) {
            len++;
            int size = nodes.size() / 2;

            while (size-- > 0) {
                int i = nodes.poll();
                int j = nodes.poll();

                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];

                    if (isValid(ni, nj, m, n) && matrix[i][j] > matrix[ni][nj]) {
                        if (--out[ni][nj] == 0) {
                            nodes.add(ni);
                            nodes.add(nj);
                        }
                    }
                }
            }
        }

        return len;
    }
}
// @lc code=end

