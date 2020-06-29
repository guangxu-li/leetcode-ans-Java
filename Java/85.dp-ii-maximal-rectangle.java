import java.util.Arrays;

/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int maxArea = 0;
        int[] leftBound = new int[matrix[0].length];
        int[] rightBound = new int[matrix[0].length];
        int[] heights = new int[matrix[0].length];

        // fill before the loop, otherwise it won't store last row's rightBound information
        Arrays.fill(rightBound, matrix[0].length);

        for (int i = 0; i < matrix.length; i++) {
            int currLeftBound = 0;

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;

                    leftBound[j] = Math.max(leftBound[j], currLeftBound);
                } else {
                    heights[j] = 0;

                    leftBound[j] = 0;
                    currLeftBound = j + 1;
                }
            }


            int currRightBound = matrix[0].length;
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    rightBound[j] = Math.min(rightBound[j], currRightBound);
                } else {
                    rightBound[j] = matrix[0].length;
                    currRightBound = j;
                }

                maxArea = Math.max(maxArea, heights[j] * (rightBound[j] - leftBound[j]));
            }

        }

        return maxArea;
    }
}
// @lc code=end

