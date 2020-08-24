/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    private int[][] M;
    private int count = 0;
    private boolean[] visited;

    private void dfs(int i) {
        visited[i] = true;

        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        this.M = M;
        this.visited = new boolean[M.length];

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        return count;
    }
}
// @lc code=end

