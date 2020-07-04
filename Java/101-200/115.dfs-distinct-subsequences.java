/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
class Solution {
    private Integer[][] cache;

    private int dfs(char[] s, int i, char[] t, int j) {
        if (cache[i][j] != null) {
            return cache[i][j];
        }

        int num = 0;
        if (j == t.length) {
            num = 1;
        } else {
            for (int pos = i; pos <= s.length - t.length + j; pos++) {
                if (s[pos] == t[j]) {
                    num += dfs(s, pos + 1, t, j + 1);
                }
            }
        }

        cache[i][j] = num;
        return num;
    }

    public int numDistinct(String s, String t) {
        cache = new Integer[s.length() + 1][t.length() + 1];
        return dfs(s.toCharArray(), 0, t.toCharArray(), 0);
    }
}
// @lc code=end

