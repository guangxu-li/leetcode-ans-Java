/*
 * @lc app=leetcode id=223 lang=java
 *
 * [223] Rectangle Area
 */

// @lc code=start
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (G <= A || E >= C || H <= B || F >= D) {
            return (C - A) * (D - B) + (G - E) * (H - F);
        }

        return (C - A) * (D - B) - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F)) + (G - E) * (H - F);
    }
}
// @lc code=end

