/*
 * @lc app=leetcode id=1335 lang=java
 *
 * [1335] Minimum Difficulty of a Job Schedule
 */

// @lc code=start
class Solution {
    private Integer[][] memo;

    private int minDifficulty(int[] difficulties, int pos, int d) {
        if (memo[pos][d] != null) {
            return memo[pos][d];
        }

        int len = difficulties.length - pos;
        int min = Integer.MAX_VALUE;

        if (d == 0) {
            if (pos == difficulties.length) {
                min = 0;
            }
        } else if (len >= d) {
            for (int i = pos, difficulty = 0; i <= difficulties.length - d; i++) {
                difficulty = Math.max(difficulty, difficulties[i]);

                int next = minDifficulty(difficulties, i + 1, d - 1);
                if (next == -1) {
                    continue;
                }

                min = Math.min(min, difficulty + next);
            }
        }

        min = min == Integer.MAX_VALUE ? -1 : min;
        memo[pos][d] = min;
        return min;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        this.memo = new Integer[jobDifficulty.length + 1][d + 1];

        return minDifficulty(jobDifficulty, 0, d);
    }
}
// @lc code=end

