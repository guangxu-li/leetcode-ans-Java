/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[] output = new int[m * n];
        int idx = 0;
        
        for (int i = 0; i <= m + n - 2; i++) {
            if (i % 2 == 0) {
                for (int j = Math.max(0, i + 1 - m); j < n && i - j >= 0; j++) {
                    output[idx++] = matrix[i - j][j];
                }
            } else {
                for (int j = Math.max(0, i + 1 - n); j < m && i - j >= 0; j++) {
                    output[idx++] = matrix[j][i - j];
                }
            }
        }
        
        return output;
    }
}
// @lc code=end

