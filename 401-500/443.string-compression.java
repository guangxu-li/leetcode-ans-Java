/*
 * @lc app=leetcode id=443 lang=java
 *
 * [443] String Compression
 */

// @lc code=start
class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        for (int i = 0, anchor = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] != chars[anchor]) {
                int len = i - anchor;
                chars[idx++] = chars[anchor];
                if (len > 1) {
                    String cnt = String.valueOf(len);
                    for (int j = 0; j < cnt.length(); j++) {
                        chars[idx++] = cnt.charAt(j);
                    }
                }
                anchor = i;
            }
        }

        return idx;
    }
}
// @lc code=end

