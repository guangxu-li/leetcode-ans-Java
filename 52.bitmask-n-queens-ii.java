/*
 * @lc app=leetcode id=52 lang=java
 *
 * [52] N-Queens II
 */

// @lc code=start
class Solution {
    private int col = 0;
    private int hill = 0;
    private int dale = 0;

    private int SIZE;

    private int ans = 0;

    public int totalNQueens(int n) {
        SIZE = n;
        backtrack(n);

        return ans;
    }

    public void backtrack(int n) {
        if (n == 0) {
            ans++;
        } else {
            int validPoints = ((1 << SIZE) - 1) & ~(col | (hill >> (n - 1)) | (dale >> (SIZE - n)));
            while (validPoints != 0) {
                int p = validPoints & -validPoints;
                validPoints ^= p;

                col ^= p;
                hill ^= (p << n - 1); /* hillIdx = i + n - 1 */
                dale ^= (p << (SIZE - n)); /* daleIdx = i - n + SIZE */

                backtrack(n - 1);

                col ^= p;
                hill ^= (p << n - 1);
                dale ^= (p << (SIZE - n));
            }
        }
    }
}
// @lc code=end

