/*
 * @lc app=leetcode id=680 lang=java
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
class Solution {
    private boolean flag = false;

    private boolean checkPalindrome(char[] s, int start, int end) {
        while (start <= end) {
            if (s[start] != s[end]) {
                if (flag) {
                    return false;
                }

                flag = true;
                return checkPalindrome(s, start + 1, end) || checkPalindrome(s, start, end - 1);
            }

            start++;
            end--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        return checkPalindrome(s.toCharArray(), 0, s.length() - 1);
    }
}
// @lc code=end

