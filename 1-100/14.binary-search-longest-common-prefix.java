/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int lo = 0;
        int hi = strs[0].length() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isCommonPrefix(strs, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return strs[0].substring(0, lo);
    }

    public boolean isCommonPrefix(String[] strs, int len) {
        String str = strs[0].substring(0, len + 1);
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].indexOf(str) != 0) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end
