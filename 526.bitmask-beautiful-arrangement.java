/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {
    private Integer[] memo;

    private int arrange(int state, int pos) {
        if (memo[state] != null) {
            return memo[state];
        }

        int cnt = 0;
        if (pos == 0) {
            cnt = 1;
        } else {
            int valid = state;
            while (valid != 0) {
                int p = valid & -valid;
                valid ^= p;

                int i = (int) (Math.log(p) / Math.log(2)) + 1;
                if (i % pos == 0 || pos % i == 0) {
                    cnt += arrange(state ^ p, pos - 1);
                }
            }
        }

        memo[state] = cnt;
        return cnt;
    }

    public int countArrangement(int n) {
        this.memo = new Integer[1 << n];

        return arrange((1 << n) - 1, n);
    }
}
// @lc code=end

