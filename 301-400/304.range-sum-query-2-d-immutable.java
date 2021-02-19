/*
 * @lc app=leetcode id=304 lang=java
 *
 * [304] Range Sum Query 2D - Immutable
 */

// @lc code=start
class NumMatrix {
    private int[][] squareSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? m : matrix[0].length;
        this.squareSum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                squareSum[i][j] = squareSum[i - 1][j] + squareSum[i][j - 1]
                        - squareSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return squareSum[row2 + 1][col2 + 1] - squareSum[row1][col2 + 1] - squareSum[row2 + 1][col1]
                + squareSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

