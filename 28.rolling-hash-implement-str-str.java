/*
 * @lc app=leetcode id=28 lang=java
 *
 * [28] Implement strStr()
 */

// @lc code=start
class Solution {
    public int parseInt(char c) {
        return c - 'a';
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length() || needle == null) {
            return -1;
        }

        long strHash = 0;
        long refHash = 0;

        long modulus = (long) Math.pow(2, 31);

        for (int i = 0; i < needle.length(); i++) {
            strHash = (strHash * 26 + parseInt(haystack.charAt(i))) % modulus;
            refHash = (refHash * 26 + parseInt(needle.charAt(i))) % modulus;
        }

        if (strHash == refHash) {
            return 0;
        }

        // * hash base of the first char
        long hi = (long) Math.pow(26, needle.length() - 1) % modulus;

        for (int i = 1; i < haystack.length() - needle.length() + 1; i++) {
            strHash = (strHash * 26 - parseInt(haystack.charAt(i - 1)) * hi * 26 % modulus
                    + parseInt(haystack.charAt(i + needle.length() - 1))) % modulus;
            if (strHash == refHash) {
                return i;
            }
        }

        return -1;
    }
}
// @lc code=end
