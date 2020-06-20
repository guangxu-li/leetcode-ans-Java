/*
 * @lc app=leetcode id=74 lang=java
 *
 * [74] Search a 2D Matrix
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int lo = 0;
        int hi = matrix.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[mid][0] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        int row = hi;
        if (row < 0) {
            return false;
        }

        lo = 0;
        hi = matrix[row].length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] < target) {
                lo = mid + 1;
            } else if (matrix[row][mid] == target) {
                return true;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }
}
// @lc code=end

