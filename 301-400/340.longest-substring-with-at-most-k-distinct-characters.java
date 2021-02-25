/*
 * @lc app=leetcode id=340 lang=java
 *
 * [340] Longest Substring with At Most K Distinct Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] cs = s.toCharArray();
        int[] found = new int[256];
        int lo = 0;
        int hi = 0;
        int cnt = 0;

        int len = 0;

        while (k > 0 && hi < s.length()) {
            if (cnt == k && found[cs[hi]] == 0) {
                if (--found[cs[lo++]] == 0) {
                    cnt--;
                }
            } else {
                if (found[cs[hi++]]++ == 0) {
                    cnt++;
                }
            }

            len = Math.max(len, hi - lo);
        }

        return len;
    }
}
// @lc code=end

