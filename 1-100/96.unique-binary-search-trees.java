/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int Cn = 1;
        for (double i = 0; i < n; ++i) {
            Cn *= 2 * (2 * i + 1) / (i + 2);
        }

        return (int) Cn;
    }
}
// @lc code=end

