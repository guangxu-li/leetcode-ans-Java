/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    private final static int SIZE = 9;
    private char[][] board = new char[9][9];

    // validity arrays
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] boxes = new int[9];

    private boolean solved = false;

    public void solveSudoku(char[][] board) {
        this.board = board;
        initialValidity(board);

        backtrack(0, 0);
    }

    private void initialValidity(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] != '.') {
                    updateValidity(row, col, board[row][col] - '0');
                }
            }
        }
    }

    private void updateValidity(int row, int col, int num) {
        rows[row] ^= 1 << (num - 1);
        cols[col] ^= 1 << (num - 1);
        boxes[3 * (row / 3) + col / 3] ^= 1 << (num - 1);
    }

    private void backtrack(int row, int col) {
        if (row == SIZE) {
            solved = true;
        } else if (board[row][col] != '.') {
            backtrack(row + (col + 1) / 9, (col + 1) % 9);
        } else {
            int validNums = 0x01ff & ~(rows[row] | cols[col] | boxes[3 * (row / 3) + col / 3]);

            while (validNums != 0) {
                int p = validNums & -validNums;
                int num = (int) (Math.log(p) / Math.log(2)) + 1;
                validNums ^= p;

                board[row][col] = (char) (num + '0');
                updateValidity(row, col, num);

                backtrack(row + (col + 1) / 9, (col + 1) % 9);

                if (solved) {
                    break;
                }

                board[row][col] = '.';
                updateValidity(row, col, num);
            }
        }
    }
}
// @lc code=end
