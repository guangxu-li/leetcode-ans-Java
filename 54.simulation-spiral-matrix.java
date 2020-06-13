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
        List<Integer> ans = new ArrayList<>();

        if (matrix.length == 0) {
            return ans;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] seen = new boolean[m][n];

        int[] dirRow = {0, 1, 0, -1};
        int[] dirCol = {1, 0, -1, 0};

        for (int i = 0, row = 0, col = 0, dir = 0; i < m * n; i++) {
            ans.add(matrix[row][col]);
            seen[row][col] = true;

            int nextRow = row + dirRow[dir];
            int nextCol = col + dirCol[dir];

            if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n
                    && !seen[nextRow][nextCol]) {
                row = nextRow;
                col = nextCol;
            } else {
                dir = (dir + 1) % 4;

                row += dirRow[dir];
                col += dirCol[dir];
            }
        }

        return ans;
    }
}
// @lc code=end

