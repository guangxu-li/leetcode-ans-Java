/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int citation : citations) {
            count[Math.min(citations.length, citation)]++;
        }

        int h = citations.length;
        int cnt = count[h];
        while (cnt < h) {
            cnt += count[--h];
        }

        return h;
    }
}
// @lc code=end

