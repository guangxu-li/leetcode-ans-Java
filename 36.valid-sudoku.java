/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {

        int[][][] validBlock = new int[3][3][9];

        int[][] validCol = new int[9][9];
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];

            int[] validRow = new int[9];
            for (int j = 0; j < row.length; j++) {
                if (Character.isDigit(row[j])) {
                    int index = Character.getNumericValue(row[j]) - 1;
                    if (validRow[index]++ != 0 || validCol[j][index]++ != 0 || validBlock[i / 3][j / 3][index]++ != 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
// @lc code=end
