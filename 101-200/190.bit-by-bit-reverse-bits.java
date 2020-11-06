/*
 * @lc app=leetcode id=190 lang=java
 *
 * [190] Reverse Bits
 */

// @lc code=start
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;

        for (int i = 0; i < 31; i++) {
            rev += n & 1;
            n >>>= 1;
            rev <<= 1;
        }

        return rev + (n & 1);
    }
}
// @lc code=end

