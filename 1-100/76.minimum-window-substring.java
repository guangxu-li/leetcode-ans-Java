/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] tCount = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }

        // index of ans window
        int start = 0;
        int end = 0;

        // ans window size
        int min = Integer.MAX_VALUE;
        int formed = 0; // number of character in t which has been included in the window

        for (int hi = 0, lo = 0; hi < s.length(); hi++) {

            // even when tCount[] <= 0, it still reduce itself by one
            if (tCount[s.charAt(hi)]-- > 0) {
                formed++;
            }

            while (lo <= hi && formed == t.length()) {
                if (hi - lo + 1 < min) {
                    min = hi - lo + 1;
                    start = lo;
                    end = hi + 1;
                }

                /* < 0, still enough number of the char in the window or not the char in t
                 * == 0, lose one kind of char in t, `formed` decrease one. */
                if (tCount[s.charAt(lo++)]++ == 0) {
                    formed--;
                }
            }
        }

        return s.substring(start, end);
    }
}
// @lc code=end
