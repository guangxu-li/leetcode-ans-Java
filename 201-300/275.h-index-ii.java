/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
    public int hIndex(int[] citations) {
       int i = 0;
       while (i < citations.length && citations[citations.length - 1 - i] > i) {
           i++;
       }

       return i;
    }
}
// @lc code=end

