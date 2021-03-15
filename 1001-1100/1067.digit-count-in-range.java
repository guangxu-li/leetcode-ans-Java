/*
 * @lc app=leetcode id=1067 lang=java
 *
 * [1067] Digit Count in Range
 */

// @lc code=start
class Solution {
    private int count(int d, int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i *= 10) {
            int left = num / i;
            int right = num % i;

            cnt += (left + 9 - d) / 10 * i + (left % 10 == d ? 1 + right : 0);
            cnt -= d == 0 ? i : 0; // 00_0_01  is not valid to be count 0 at the _ _ pos
        }

        return cnt;
    }

    public int digitsCount(int d, int low, int high) {
        return count(d, high) - count(d, low - 1);
    }
}
// @lc code=end

