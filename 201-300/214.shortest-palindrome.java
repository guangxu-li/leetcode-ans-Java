/*
 * @lc app=leetcode id=214 lang=java
 *
 * [214] Shortest Palindrome
 */

// @lc code=start
class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s).reverse();

        /* 1. Add '#' to deal with s = ""
         * 2. rev + "#" + s is wrong since we're trying to find longest prefix not suffix */
        StringBuilder ns = new StringBuilder(s).append('#').append(rev);

        int[] f = new int[ns.length()];
        
        for (int i = 1; i < ns.length(); i++) {
            int t = f[i - 1];
            while (t > 0 && ns.charAt(t) != ns.charAt(i)) {
                t = f[t - 1];
            }

            if (ns.charAt(t) == ns.charAt(i)) {
                t++;
            }

            f[i] = t;
        }

        return rev.substring(0, s.length() - f[ns.length() - 1]) + s;
    }
}
// @lc code=end

