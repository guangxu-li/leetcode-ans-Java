/*
 * @lc app=leetcode id=240 lang=java
 *
 * [240] Search a 2D Matrix II
 */

// @lc code=start
class Solution {
    private int lastSmallerRow(int[][] matrix, int col, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (matrix[mid][col] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return hi;
    }

    private int firstBiggerCol(int[][] matrix, int row, int target, int lo, int hi) {
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            }

            row = lastSmallerRow(matrix, col, target, 0, row);
            if (row < 0) {
                return false;
            }
            col = firstBiggerCol(matrix, row, target, col, matrix[0].length - 1);
        }

        return false;
    }
}
// @lc code=end

