/*
 * @lc app=leetcode id=308 lang=java
 *
 * [308] Range Sum Query 2D - Mutable
 */

// @lc code=start
class NumMatrix {
    private int[][] rowSums;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        this.rowSums = new int[m][n + 1];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                rowSums[row][col + 1] = rowSums[row][col] + matrix[row][col];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = col + 1; i < rowSums[row].length; i++) {
            rowSums[row][i] += diff;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += rowSums[i][col2 + 1] - rowSums[i][col1];
        }

        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

