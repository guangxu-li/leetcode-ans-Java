/*
 * @lc app=leetcode id=1051 lang=java
 *
 * [1051] Height Checker
 */

// @lc code=start
class Solution {
    public int heightChecker(int[] heights) {
        // according to description of leetcode problem 1051
        int[] hc = new int[100];

        for (int h : heights) {
            hc[h - 1]++;
        }

        int count = 0;
        int cur = 0;
        for (int h : heights) {
            while (hc[cur]-- == 0) {
                cur++;
            }

            if (cur != h - 1) {
                count++;
            }
        }

        return count;
    }
}
// @lc code=end

