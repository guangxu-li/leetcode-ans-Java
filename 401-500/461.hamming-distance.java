/*
 * @lc app=leetcode id=461 lang=java
 *
 * [461] Hamming Distance
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        x ^= y;
        int cnt = 0;
        while (x > 0) {
            cnt++;
            x &= (x - 1);
        }

        return cnt;
    }
}
// @lc code=end

