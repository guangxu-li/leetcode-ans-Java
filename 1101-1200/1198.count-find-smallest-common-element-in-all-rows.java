/*
 * @lc app=leetcode id=1198 lang=java
 *
 * [1198] Find Smallest Common Element in All Rows
 */

// @lc code=start
class Solution {
    public int smallestCommonElement(int[][] mat) {
        int[] counts = new int[10000];
        
        for (int[] row : mat) {
            for (int val : row) {
                if (++counts[val - 1] == mat.length) {
                    return val;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

