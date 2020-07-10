/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        if (haystack.isEmpty()) {
            return -1;
        }

        int lo = 0;

        while (lo < haystack.length() - needle.length() + 1) {
            if (haystack.charAt(lo) != needle.charAt(0)) {
                lo++;
                continue;
            }

            int hi = lo;

            while (hi - lo < needle.length()) {
                if (haystack.charAt(hi) == needle.charAt(hi - lo)) {
                    hi++;
                } else {
                    break;
                }
            }

            if (hi == lo + needle.length()) {
                return lo;
            } else {
                lo++;
            }
        }

        return -1;
    }
}
// @lc code=end
