/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        char[] tc = t.toCharArray();
        int[] tcount = new int[256];
        for (char c : tc) {
            tcount[c]++;
        }

        int[][] sc = new int[s.length()][];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tcount[c] > 0) {
                sc[index++] = new int[] {i, c};
            }
        }

        int unformed = t.length(); // number of characters in t has not been included

        // candidate window info
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        // current window info
        int lo = 0;
        int hi = 0;
        while (hi < index) {
            if (tcount[sc[hi][1]]-- > 0) {
                unformed--;
            }

            while (lo <= hi && unformed == 0) {
                int high = sc[hi][0];
                int low = sc[lo][0];
                if (high - low + 1 < minLen) {
                    minLen = high - low + 1;
                    start = low;
                    end = high + 1;
                }

                if (tcount[sc[lo++][1]]++ == 0) {
                    unformed++;
                }
            }

            hi++;
        }

        /* default return ""
         * start to end + 1 will default return s.charAt[0] which may
         * lead to some problem */
        return s.substring(start, end);
    }
}
// @lc code=end

