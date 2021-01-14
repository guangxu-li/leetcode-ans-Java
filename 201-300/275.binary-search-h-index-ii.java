/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int lo = 0;
        int hi = n - 1;


        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int citation = citations[n - 1 - mid];

            if (citation > mid) {
                lo = mid + 1;
            } else if (citation == mid) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}
// @lc code=end

