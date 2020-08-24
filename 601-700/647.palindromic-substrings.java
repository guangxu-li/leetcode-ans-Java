/*
 * @lc app=leetcode id=647 lang=java
 *
 * [647] Palindromic Substrings
 */

// @lc code=start
class Solution {
    public int countSubstrings(String s) {
        char[] schars = new char[s.length() * 2 + 3];
        int si = 0;
        schars[si++] = '@';
        schars[si++] = '#';
        schars[schars.length - 1] = '$';

        for (char c : s.toCharArray()) {
            schars[si++] = c;
            schars[si++] = '#';
        }

        int count = 0;
        int[] p = new int[schars.length];
        for (int i = 1, rightMost = 0, center = 0; i < schars.length - 1; i++) {
            if (i < rightMost) {
                p[i] = Math.min(rightMost, p[2 * center - i]);
            }

            while (schars[i - p[i] - 1] == schars[i + p[i] + 1]) {
                p[i]++;
            }

            if (p[i] > rightMost) {
                rightMost = p[i];
                center = i;
            }

            count += (p[i] + 1) / 2;
        }

        return count;
    }
}
// @lc code=end

