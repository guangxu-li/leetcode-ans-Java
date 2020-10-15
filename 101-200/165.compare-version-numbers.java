/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");

        for (int i = 0; i < Math.max(v1s.length, v2s.length); i++) {
            int v1 = i < v1s.length ? Integer.parseInt(v1s[i]) : 0;
            int v2 = i < v2s.length ? Integer.parseInt(v2s[i]) : 0;

            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            }
        }

        return 0;
    }
}
// @lc code=end

