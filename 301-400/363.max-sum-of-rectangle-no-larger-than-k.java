/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] rowSums = new int[m][n + 1];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                rowSums[row][col + 1] = rowSums[row][col] + matrix[row][col];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                int curMax = 0;
                int globalMax = Integer.MIN_VALUE;

                for (int bottom = 0; bottom < m; bottom++) {
                    int curRowSum = rowSums[bottom][right + 1] - rowSums[bottom][left];
                    curMax = Math.max(curMax + curRowSum, curRowSum);
                    globalMax = Math.max(curMax, globalMax);

                    if (globalMax == k) {
                        return k;
                    }
                }

                if (globalMax < k) {
                    max = Math.max(max, globalMax);
                } else {
                    for (int up = 1; up < m; up++) {
                        int area = 0;

                        for (int bottom = up; bottom < m; bottom++) {
                            int curRowSum = rowSums[bottom][right + 1] - rowSums[bottom][left];
                            area += curRowSum;
                            
                            if (area <= k) {
                                max = Math.max(area, max);
                            }
                        }
                    }
                }
            }
        }

        return max;
    }
}
// @lc code=end

