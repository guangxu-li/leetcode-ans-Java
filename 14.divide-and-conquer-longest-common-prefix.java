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
        } else if (strs.length == 1) {
            return strs[0];
        } else if (strs.length == 2) {
            for (int i = 0; i < strs[0].length(); i++) {
                if (i == strs[1].length() || strs[0].charAt(i) != strs[1].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
            
            return strs[0];
        } else {
            int l = strs.length / 2;

            return longestCommonPrefix(new String[]{longestCommonPrefix(Arrays.copyOfRange(strs, 0, l))
                                                  , longestCommonPrefix(Arrays.copyOfRange(strs, l, strs.length))});
        }
    }
}
// @lc code=end

