import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> output = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++) {
                output.add(matrix[top][col]);
            }

            for (int row = top + 1; row <= bottom; row++) {
                output.add(matrix[row][right]);
            }

            for (int col = right - 1; top < bottom && col >= left; col--) {
                output.add(matrix[bottom][col]);
            }

            for (int row = bottom - 1; left < right && row > top; row--) {
                output.add(matrix[row][left]);
            }

            top++;
            bottom--;
            left++;
            right--;
        }

        return output;
    }
}
// @lc code=end

