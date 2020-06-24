/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int count = 0;
        int oneStep = 1;
        int twoStep = 0;

        for (int pos = s.length() - 1; pos >= 0; pos--) {
            count = 0;
            int curr = s.charAt(pos) - '0';
            int next = pos == s.length() - 1 ? -1 : s.charAt(pos + 1) - '0';

            if (curr != 0) {
                count += oneStep;

                if (next >= 0 && curr * 10 + next <= 26) {
                    count += twoStep;
                }
            }

            twoStep = oneStep;
            oneStep = count;
        }

        return count;
    }
}
// @lc code=end

