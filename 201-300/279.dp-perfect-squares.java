import java.util.Arrays;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int[] squareNums = new int[(int) Math.sqrt(n) + 1];
        for (int i = 0; i < squareNums.length; i++) {
            squareNums[i] = i * i;
        }

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < squareNums.length && i >= squareNums[j]; j++) {
                dp[i] = Math.min(dp[i], dp[i - squareNums[j]] + 1); 
            }
        }

        return dp[n];
    }
}
// @lc code=end

