/*
 * @lc app=leetcode id=1163 lang=java
 *
 * [1163] Last Substring in Lexicographical Order
 */

// @lc code=start
class Solution {
    public String lastSubstring(String s) {
        char[] schars = s.toCharArray();

        int start = 0;
        for (int cur = 1, i = 0, j = 0; cur < schars.length; cur++) {
            if (schars[cur] < schars[start]) {
                continue;
            }

            i = start;
            j = cur;

            while (j < schars.length && schars[i] == schars[j]) {
                i++;
                j++;
            }

            if (j == schars.length) {
                break;
            }

            if (schars[i] < schars[j]) {
                start = cur;
            } else {
                cur = j;
            }
        }

        return s.substring(start, schars.length);
    }
}
// @lc code=end

