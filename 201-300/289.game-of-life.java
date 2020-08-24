/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        int[] dirs = new int[] {-1, 0, 1};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int live = 0;

                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (dirs[m] == 0 && dirs[n] == 0) {
                            continue;
                        }

                        int row = i + dirs[m];
                        int col = j + dirs[n];

                        if (row >= 0 && row < board.length && col >= 0 && col < board[i].length
                                && Math.abs(board[row][col]) == 1) {
                            live++;
                        }
                    }
                }

                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = -1;
                } else if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }
}
// @lc code=end

