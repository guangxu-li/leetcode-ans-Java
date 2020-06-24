import java.util.Arrays;

/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    private int[] count;

    public int numDecodings(String s) {
        count = new int[s.length() + 1];
        Arrays.fill(count, -1);

        return dfs(s.toCharArray(), 0);
    }

    private int dfs(char[] s, int pos) {

        if (count[pos] != -1) {
            return count[pos];
        }

        int num = 0;
        if (pos == s.length) {
            num += pos == 0 ? 0 : 1;
        } else if (s[pos] - '0' == 0) {
            num = 0;
        } else {
            num += dfs(s, pos + 1);

            if (pos < s.length - 1
                    && (s[pos] - '0' < 2 || (s[pos] - '0' == 2 && s[pos + 1] - '0' <= 6))) {
                num += dfs(s, pos + 2);
            }
        }

        count[pos] = num;
        return num;
    }
}
// @lc code=end

