/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n != 0 && ((long) n & ((long) n - 1)) == 0;    
    }
}
// @lc code=end

