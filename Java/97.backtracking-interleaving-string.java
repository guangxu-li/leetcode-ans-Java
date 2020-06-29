/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    private enum Result {
        TRUE, FALSE
    }

    private Result[][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        cache = new Result[s1.length() + 1][s2.length() + 1];

        return s1.length() + s2.length() == s3.length()
                && dfs(s1.toCharArray(), 0, s2.toCharArray(), 0, s3.toCharArray(), 0);
    }

    private boolean dfs(char[] s1, int pos1, char[] s2, int pos2, char[] s3, int pos3) {
        if (cache[pos1][pos2] != null) {
            return cache[pos1][pos2] == Result.TRUE;
        }

        boolean isInterleave = false;

        if (pos1 == s1.length && pos2 == s2.length && pos3 == s3.length) {
            isInterleave = true;
        } else {
            if (pos1 != s1.length && s1[pos1] == s3[pos3]) {
                isInterleave = dfs(s1, pos1 + 1, s2, pos2, s3, pos3 + 1);
            }

            if (!isInterleave && pos2 != s2.length && s2[pos2] == s3[pos3]) {
                isInterleave = dfs(s1, pos1, s2, pos2 + 1, s3, pos3 + 1);
            }
        }

        cache[pos1][pos2] = isInterleave ? Result.TRUE : Result.FALSE;
        return isInterleave;
    }
}
// @lc code=end

