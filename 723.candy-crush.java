/*
 * @lc app=leetcode id=723 lang=java
 *
 * [723] Candy Crush
 */

// @lc code=start
class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean todo = false;
        do {
            todo = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j + 2 < n; j++) {
                    int anchor = Math.abs(board[i][j]);
                    if (anchor > 0 && anchor == Math.abs(board[i][j + 1])
                            && anchor == Math.abs(board[i][j + 2])) {
                        todo = true;
                        board[i][j] = board[i][j + 1] = board[i][j + 2] = -anchor;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 0; i + 2 < m; i++) {
                    int anchor = Math.abs(board[i][j]);
                    if (anchor > 0 && anchor == Math.abs(board[i + 1][j])
                            && anchor == Math.abs(board[i + 2][j])) {
                        board[i][j] = board[i + 1][j] = board[i + 2][j] = -anchor;
                        todo = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                int idx = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] > 0) {
                        board[idx--][j] = board[i][j];
                    }
                }

                while (idx >= 0) {
                    board[idx--][j] = 0;
                }
            }
        } while (todo);

        return board;
    }
}
// @lc code=end

