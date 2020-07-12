/*
 * @lc app=leetcode id=132 lang=java
 *
 * [132] Palindrome Partitioning II
 */

// @lc code=start
class Solution {
    private char[] str;
    private boolean[][] isPalindrome;
    private Integer[][] mins;

    private int dfs(int start, int end) {
        int min = Integer.MAX_VALUE;
        if (start > end) {
            return 0;
        } else {
            if (mins[start][end] != null) {
                return mins[start][end];
            }

            for (int i = start; i <= end; i++) {
                if (isPalindrome[start][i]) {
                    min = Math.min(min, 1 + dfs(i + 1, end));
                }
            }
        }

        mins[start][end] = min;
        return min;
    }

    private void palindrome(char[] str) {
        for (int len = 0; len < str.length; len++) {
            for (int i = 0; i + len < str.length; i++) {
                if (len <= 1) {
                    isPalindrome[i][i + len] = str[i] == str[i + len];
                } else {
                    isPalindrome[i][i + len] =
                            str[i] == str[i + len] && isPalindrome[i + 1][i + len - 1];
                }
            }
        }
    }

    public int minCut(String s) {
        this.str = s.toCharArray();
        this.isPalindrome = new boolean[str.length][str.length];
        this.mins = new Integer[str.length][str.length];

        palindrome(str);
        return dfs(0, str.length - 1) - 1;
    }
}
// @lc code=end

