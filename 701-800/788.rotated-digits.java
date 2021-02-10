/*
 * @lc app=leetcode id=788 lang=java
 *
 * [788] Rotated Digits
 */

// @lc code=start
class Solution {
    private static final char[] mapping = new char[] {'0', '1', '2', '5', '6', '8', '9'};
    private Integer[][][] memo;

    private boolean validDigits(char digit) {
        return digit == '2' || digit == '5' || digit == '6' || digit == '9';
    }

    private int generate(int pos, char[] limits, boolean isLimited, boolean isValid) {
        int l = isLimited ? 1 : 0;
        int v = isValid ? 1 : 0;

        if (memo[pos][l][v] != null) {
            return memo[pos][l][v];
        }

        int cnt = 0;
        if (pos == limits.length) {
            if (isValid) {
                cnt = 1;
            }
        } else {
            for (char digit : mapping) {
                if (isLimited && digit > limits[pos]) {
                    break;
                }
                
                boolean limited = isLimited && digit == limits[pos];
                boolean valid = isValid || validDigits(digit);
                cnt += generate(pos + 1, limits, limited, valid);
            }
        }

        memo[pos][l][v] = cnt;
        return cnt;
    }

    public int rotatedDigits(int N) {
        char[] limits = String.valueOf(N).toCharArray();
        this.memo = new Integer[limits.length + 1][2][2];

        return generate(0, limits, true, false);
    }
}
// @lc code=end

