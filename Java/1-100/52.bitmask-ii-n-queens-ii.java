/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private int SIZE;

    private int ans = 0;

    public int totalNQueens(int n) {
        SIZE = n;
        backtrack(0, 0, 0, 0);

        return ans;
    }

    public void backtrack(int n, int col, int hill, int dale) {
        if (n == SIZE) {
            ans++;
        } else {
            int validPoints = ((1 << SIZE) - 1) & ~(col | hill | dale);
            while (validPoints != 0) {
                int p = validPoints & -validPoints;
                validPoints ^= p;

                backtrack(n + 1, col ^ p, (hill ^ p) << 1, (dale ^ p) >> 1);
            }
        }
    }
}
// @lc code=end

