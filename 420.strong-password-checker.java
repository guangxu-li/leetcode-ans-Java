/*
 * @lc app=leetcode id=420 lang=java
 *
 * [420] Strong Password Checker
 */

// @lc code=start
class Solution {
    public int strongPasswordChecker(String s) {
        int uppercase = 1;
        int lowercase = 1;
        int digit = 1;

        char anchor = 0;
        int len = 0; // length of repeating pattern
        int replace = 0; // number of replace operation to remove repeating pattern like "aaa"

        int[] del = new int[3]; // dp[i] -> i - 1 delete operation to remove repeating pattern

        for (int i = 0; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == anchor) {
                len++;
            } else {
                int rep = len / 3;
                replace += rep;

                if (rep > 0) {
                    del[len % 3]++;
                }

                if (i < s.length()) {
                    char c = s.charAt(i);

                    uppercase &= c >= 'A' && c <= 'Z' ? 0 : 1;
                    lowercase &= c >= 'a' && c <= 'z' ? 0 : 1;
                    digit &= c >= '0' && c <= '9' ? 0 : 1;

                    anchor = c;
                }

                len = 1;
            }
        }

        int mostContain = uppercase + lowercase + digit;
        System.out.println(mostContain);
        if (s.length() < 6) {
            return Math.max(6 - s.length(), mostContain);
        } else if (s.length() <= 20) {
            return Math.max(replace, mostContain);
        } else {
            int rem = s.length() - 20;

            if (rem <= del[0]) {
                replace -= rem;
            } else if (rem - del[0] <= 2 * del[1]) {
                replace -= del[0] + (rem - del[0]) / 2;
            } else {
                replace -= del[0] + del[1] + (rem - del[0] - 2 * del[1]) / 3;
            }

            return rem + Math.max(mostContain, replace);
        }
    }
}
// @lc code=end

