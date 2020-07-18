/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }

        int cur = 1;
        int sum = 1;
        int dir = 0;
        long peak = Long.MAX_VALUE;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                if (dir == -1) {
                    cur = 1;
                }

                cur++;
                dir = 1;
            } else if (ratings[i - 1] == ratings[i]) {
                cur = 1;
                peak = Long.MAX_VALUE;
                dir = 0;
            } else {
                if (dir == 1) {
                    peak = cur;
                    cur = 0;
                }

                if (++cur == peak) {
                    peak++;
                    sum++;
                }

                dir = -1;
            }

            sum += cur;
        }

        return sum;
    }
}
// @lc code=end

