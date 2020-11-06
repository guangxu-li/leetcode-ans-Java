/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 */

// @lc code=start
class Solution {
    private void reverse(char[] s, int lo, int hi) {
        while (lo < hi) {
            swap(s, lo++, hi--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);

        for (int i = 0, anchor = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, anchor, i - 1);
                anchor = i + 1;
            }
        }
    }
}
// @lc code=end

