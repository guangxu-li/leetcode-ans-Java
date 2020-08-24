/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int lo = 0;
        int hi = 0;
        int anchor = 0;

        while (hi < chars.length) {
            if (hi == chars.length - 1 || chars[anchor] != chars[hi + 1]) {
                chars[lo++] = chars[anchor];

                // count = read - anchor  + 1 > 1
                if (hi > anchor) {
                    for (char c : Integer.toString(hi - anchor).toCharArray()) {
                        chars[lo++] = c;
                    }
                }

                anchor = hi + 1;
            }

            hi++;
        }

        return lo;
    }
}
// @lc code=end

