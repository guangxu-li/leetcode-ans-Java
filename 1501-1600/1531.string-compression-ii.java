/*
 * @lc app=leetcode id=1531 lang=java
 *
 * [1531] String Compression II
 */

// @lc code=start
class Solution {
    private Integer[][] memo;

    private int dfs(char[] cs, int pos, int k) {
        if (k < 0) {
            return cs.length;
        } else if (pos < k) {
            return 0;
        }

        if (memo[pos][k] != null) {
            return memo[pos][k];
        }

        int min = dfs(cs, pos - 1, k - 1);
        for (int i = pos, dup = 0, diff = 0, size = 0; i >= 0 && k >= diff; i--) {
            if (cs[i] == cs[pos]) {
                dup++;

                if (dup <= 2 || dup == 10 || dup == 100) {
                    size++;
                }
            } else {
                diff++;
            }

            min = Math.min(min, size + dfs(cs, i - 1, k - diff));
        }

        memo[pos][k] = min;
        return min;
    }

    public int getLengthOfOptimalCompression(String s, int k) {
        this.memo = new Integer[s.length()][k + 1];

        return dfs(s.toCharArray(), s.length() - 1, k);
    }
}
// @lc code=end
