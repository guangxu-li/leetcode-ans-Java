/*
 * @lc app=leetcode id=1198 lang=java
 *
 * [1198] Find Smallest Common Element in All Rows
 */

// @lc code=start
class Solution {
    public int smallestCommonElement(int[][] mat) { // o(mn)
        int[] pos = new int[mat.length];
        int max = 0;
        int cnt = 0;

        while (true) {
            for (int i = 0; i < mat.length; i++) {
                int step = 1;
                while (pos[i] < mat[0].length && mat[i][pos[i]] < max) {
                    if (mat[i][Math.min(pos[i] + step, mat[0].length - 1)] >= max) {
                        step = 1;
                    }
                    
                    pos[i] += step;
                    step <<= 1;
                }

                if (pos[i] >= mat[0].length) {
                    return -1;
                }

                if (mat[i][pos[i]] > max) {
                    max = mat[i][pos[i]];
                    cnt = 1;
                } else if (++cnt == mat.length) {
                    return max; 
                }
            }
        }
    }
}
// @lc code=end

