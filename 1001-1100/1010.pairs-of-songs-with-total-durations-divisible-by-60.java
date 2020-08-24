/*
 * @lc app=leetcode id=1010 lang=java
 *
 * [1010] Pairs of Songs With Total Durations Divisible by 60
 */

// @lc code=start
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] tc = new int[60];

        int count = 0;
        for (int t : time) {
            t %= 60;
            int target = (60 - t) % 60;
            count += tc[target];
            tc[t]++;
        }

        return count;
    }
}
// @lc code=end

