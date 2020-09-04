/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        char[] cs = S.toCharArray();

        int[] count = new int[26];
        int maxIndice = -1;
        int max = 0;

        for (char c : cs) {
            int i = c - 'a';
            count[i]++;

            if (max < count[i]) {
                max = count[i];
                maxIndice = i;
            }
        }

        if (max > (cs.length + 1) / 2) {
            return "";
        }

        char[] s = new char[cs.length];
        int i = 0;

        for (int n = maxIndice; n < maxIndice + 26; n++) {
            while (count[n % 26]-- > 0) {
                if (i >= s.length) {
                    i = 1;
                }

                s[i] = (char) ('a' + n % 26);
                i += 2;
            }
        }

        return String.valueOf(s);
    }
}
// @lc code=end

