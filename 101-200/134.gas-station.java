/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int curGas = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];

            if (curGas < 0) {
                start = i + 1;
                curGas = 0;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}
// @lc code=end

