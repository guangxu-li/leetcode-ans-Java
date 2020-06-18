/*
 * @lc app=leetcode id=62 lang=java
 *
 * [62] Unique Paths
 */

// @lc code=start
class Solution {
    private int numOfPaths = 0;
    private int m;
    private int n;

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;

        backtrack(0, 0);

        return numOfPaths;
    }

    private void backtrack(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            numOfPaths++;
        } else if (x == m || y == n) {
            return;
        } else {
            backtrack(x + 1, y);
            backtrack(x, y + 1);
        }
    }
}
// @lc code=end

