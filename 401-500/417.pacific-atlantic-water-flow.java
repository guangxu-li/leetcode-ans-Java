import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private List<List<Integer>> cells = new ArrayList<>();
    private int m;
    private int n;

    private void dfs(int i, int j, boolean flag, int[][] visited, int[][] matrix) {
        if ((flag && visited[i][j] == 1) || visited[i][j] < 0) {
            return;
        }
        visited[i][j] = flag ? visited[i][j] + 1 : -visited[i][j] - 1;

        if (!flag && visited[i][j] == -2) {
            List<Integer> pos = new ArrayList<>();
            pos.add(i);
            pos.add(j);
            cells.add(pos);
        }

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni < 0 || ni == m || nj < 0 || nj == n || matrix[i][j] > matrix[ni][nj]) {
                continue;
            }

            dfs(ni, nj, flag, visited, matrix);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        if (matrix.length == 0) {
            return cells;
        }

        this.m = matrix.length;
        this.n = matrix[0].length;

        int[][] visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            dfs(i, 0, true, visited, matrix);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, true, visited, matrix);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, false, visited, matrix);
        }
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, false, visited, matrix);
        }
        return cells;
    }
}
// @lc code=end

