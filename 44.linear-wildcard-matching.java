/*
 * @lc app=leetcode id=44 lang=java
 *
 * [44] Wildcard Matching
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0;
        int pIdx = 0;

        int sStar = -1;
        int pStar = -1;

        while (sIdx < s.length()) {

            /*
             * if pIdx == p.length() 
             * -> check if it's in '*' attmpting process 
             * -> if not, failed to match
             */
            if (pIdx < p.length() && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
                pIdx++;
                sIdx++;
            } else if (pIdx < p.length() && (p.charAt(pIdx) == '*')) {
                pStar = ++pIdx;
                sStar = sIdx;
            } else if (sStar != -1) { /* fail to match in '*' attmpting process */
                pIdx = pStar;
                sIdx = ++sStar;
            } else { /* not in '*' attmpting process and fail to math */
                return false;
            }
        }

        while (pIdx < p.length()) {
            if (p.charAt(pIdx) != '*') {
                return false;
            }

            pIdx++;
        }

        return true;
    }
}
// @lc code=end

