/*
 * @lc app=leetcode id=248 lang=java
 *
 * [248] Strobogrammatic Number III
 */

// @lc code=start
class Solution {
    private char[][] pairs =
            new char[][] {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    private int count;
    private String low;
    private String high;

    private void find(char[] cs, int lo, int hi) {
        if (lo > hi) {
            String s = String.valueOf(cs);

            if ((cs.length == low.length() && s.compareTo(low) < 0)
                    || (cs.length == high.length() && s.compareTo(high) > 0)) {
                return;
            }

            count++;
        } else for (char[] pair : pairs) {
            cs[lo] = pair[0];
            cs[hi] = pair[1];

            if (cs.length != 1 && cs[0] == '0') {
                continue;
            }

            if (lo == hi && pair[0] != pair[1]) {
                continue;
            }

            find(cs, lo + 1, hi - 1);
        }
    }

    public int strobogrammaticInRange(String low, String high) {
        this.low = low;
        this.high = high;

        for (int len = low.length(); len <= high.length(); len++) {
            find(new char[len], 0, len - 1);
        }

        return count;
    }
}
// @lc code=end

