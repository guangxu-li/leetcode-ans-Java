/*
 * @lc app=leetcode id=246 lang=java
 *
 * [246] Strobogrammatic Number
 */

// @lc code=start
class Solution {
    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length() - i - 1; i <= j; i++, j--) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(j);

            if (c1 == c2) {
                if (c1 != '0' && c1 != '1' && c1 != '8') {
                    return false;
                }
            } else {
                if (!(c1 == '6' && c2 == '9') && !(c1 == '9' && c2 == '6')) {
                    return false;
                }
            }
        }

        return true;
    }
}
// @lc code=end

