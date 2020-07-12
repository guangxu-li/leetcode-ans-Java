/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    private char[][] board;
    private int rows;
    private int cols;
    private boolean[][] visited;

    private void dfs(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == 'X' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0);
            dfs(i, cols - 1);
        }

        for (int i = 0; i < cols; i++) {
            dfs(0, i);
            dfs(rows - 1, i);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
// @lc code=end

