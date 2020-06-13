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

        int loRow = 0;
        int hiRow = matrix.length - 1;

        int loCol = 0;
        int hiCol = matrix[0].length - 1;

        while (loRow <= hiRow && loCol <= hiCol) {
            for (int col = loCol; col <= hiCol; col++) {
                ans.add(matrix[loRow][col]);
            }

            for (int row = loRow + 1; row <= hiRow; row++) {
                ans.add(matrix[row][hiCol]);
            }

            if (loRow != hiRow && loCol != hiCol) {
                for (int col = hiCol - 1; col >= loCol; col--) {
                    ans.add(matrix[hiRow][col]);
                }

                for (int row = hiRow - 1; row > loRow; row--) {
                    ans.add(matrix[row][loCol]);
                }
            }

            loRow++;
            hiRow--;

            loCol++;
            hiCol--;
        }

        return ans;
    }
}
// @lc code=end

