/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;

        for (int N = 1; N <= n; N++) {
            for (int i = 1; i <= N; i++) {
                G[N] += G[i - 1] * G[N - i];
            }
        }

        return G[n];
    }
}
// @lc code=end

