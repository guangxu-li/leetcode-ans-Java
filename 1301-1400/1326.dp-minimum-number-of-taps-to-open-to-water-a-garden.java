/*
 * @lc app=leetcode id=1326 lang=java
 *
 * [1326] Minimum Number of Taps to Open to Water a Garden
 */

// @lc code=start
class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] maxRight = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int l = Math.max(0, i - ranges[i]);
            int r = i + ranges[i];
            maxRight[l] = Math.max(maxRight[l], r);
        }

        int cnt = 0;
        for (int i = 0, covered = 0; covered < n; cnt++) {
            int max = covered;
            while (i <= covered) {
                max = Math.max(max, maxRight[i++]);
            }

            if (max == covered) {
                return -1;
            }

            covered = max;
        }

        return cnt;
    }
}
// @lc code=end


