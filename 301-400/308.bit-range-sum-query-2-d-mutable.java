/*
 * @lc app=leetcode id=308 lang=java
 *
 * [308] Range Sum Query 2D - Mutable
 */

// @lc code=start
class NumMatrix {
    private int[][] bit;
    private int[][] matrix;
    private int m, n;

    private int query(int row, int col) {
        int sum = 0;
        for (int i = row; i > 0; i -= i & -i) {
            for (int j = col; j > 0; j -= j & -j) {
                sum += bit[i][j];
            }
        }


        return sum;
    }

    private void updateBit(int row, int col, int val) {
        for (int i = row; i <= m; i += i & -i) {
            for (int j = col; j <= n; j += j & -j) {
                bit[i][j] += val;
            }
        }
    }

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = m == 0 ? 0 : matrix[0].length;
        this.bit = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int val = matrix[i - 1][j - 1];
                bit[i][j] += val;
                int k = j + (j & -j);
                if (k <= n) {
                    bit[i][k] += bit[i][j];
                }
            }
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                int k = i + (i & -i);
                if (k <= m) {
                    bit[k][j] += bit[i][j];
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        updateBit(row + 1, col + 1, diff);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return query(row2 + 1, col2 + 1) - query(row1, col2 + 1) - query(row2 + 1, col1)
                + query(row1, col1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

