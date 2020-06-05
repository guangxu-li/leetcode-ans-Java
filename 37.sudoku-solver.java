/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    private int boxSize;
    private int boardSize;

    private int[][] rows;
    private int[][] cols;
    private int[][][] boxes;

    private char[][] board;

    private boolean solved;

    Solution() {
        boxSize = 3;
        boardSize = boxSize * boxSize;

        rows = new int[boardSize][boardSize];
        cols = new int[boardSize][boardSize];
        boxes = new int[boxSize][boxSize][boardSize];

        board = new char[boardSize][boardSize];

        solved = false;
    }

    public boolean isValid(int row, int col, int num) {
        return rows[row][num - 1] //
                + cols[col][num - 1] //
                + boxes[row / 3][col / 3][num - 1] //
                == 0;
    }

    public void placeNumber(int row, int col, int num) {
        rows[row][num - 1]++;
        cols[col][num - 1]++;
        boxes[row / 3][col / 3][num - 1]++;

        board[row][col] = (char) (num + '0');
    }

    public void placeNextNumber(int row, int col) {
        if (row == boardSize - 1 && col == boardSize - 1) {
            solved = true;
            return;
        }

        if (col == boardSize - 1) {
            backtrack(row + 1, 0);
        } else {
            backtrack(row, col + 1);
        }
    }

    public void removeNumber(int row, int col, int num) {
        rows[row][num - 1]--;
        cols[col][num - 1]--;
        boxes[row / 3][col / 3][num - 1]--;

        board[row][col] = '.';
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d <= 9; d++) {
                if (isValid(row, col, d)) {
                    placeNumber(row, col, d);
                    placeNextNumber(row, col);

                    if (!solved) {
                        removeNumber(row, col, d);
                    }
                }
            }
        } else {
            placeNextNumber(row, col);
        }
    }

    public void solveSudoku(char[][] board) {
        this.board = board;

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] != '.') {
                    int num = Character.getNumericValue(board[i][j]);
                    placeNumber(i, j, num);
                }
            }
        }

        backtrack(0, 0);
    }
}
// @lc code=end
