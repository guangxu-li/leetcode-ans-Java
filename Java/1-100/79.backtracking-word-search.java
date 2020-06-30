/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    private char[][] board;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(1, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int pos, int i, int j) {
        char prev = board[i][j];
        board[i][j] = '.';

        if (pos == word.length()) {
            return true;
        } else {
            if (i > 0 && board[i - 1][j] == word.charAt(pos) && backtrack(pos + 1, i - 1, j)) {
                return true;
            } else if (i < board.length - 1 && board[i + 1][j] == word.charAt(pos)
                    && backtrack(pos + 1, i + 1, j)) {
                return true;
            } else if (j > 0 && board[i][j - 1] == word.charAt(pos)
                    && backtrack(pos + 1, i, j - 1)) {
                return true;
            } else if (j < board[0].length - 1 && board[i][j + 1] == word.charAt(pos)
                    && backtrack(pos + 1, i, j + 1)) {
                return true;
            }

            board[i][j] = prev;
            return false;
        }
    }
}
// @lc code=end

