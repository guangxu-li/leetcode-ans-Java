/*
 * @lc app=leetcode id=829 lang=java
 *
 * [829] Consecutive Numbers Sum
 */

// @lc code=start
class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        int bound = (int) (Math.sqrt(2 * N + 0.25) - 0.5);
        for (int i = 1; i <= bound; i++) {
            if (N % i == i * (i + 1) / 2 % i) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

