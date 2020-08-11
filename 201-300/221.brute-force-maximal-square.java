/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
    private boolean isValid(char[][] matrix, int row, int col, int len) {
        if (row + len > matrix.length || col + len > matrix[0].length) {
            return false;
        }

        for (int i = row; i < row + len; i++) {
            for (int j = col; j < col + len; j++) {
                if (matrix[i][j] == '0') {
                    return false;
                }
            }
        }

        return true;
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxLen = 0;
        for (int i = 0; i + maxLen < matrix.length; i++) {
            for (int j = 0; j + maxLen < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    while (isValid(matrix, i, j, maxLen + 1)) {
                        maxLen++;
                    }
                }
            }
        }

        return maxLen * maxLen;
    }
}
// @lc code=end

