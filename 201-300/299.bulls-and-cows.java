/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int[] counts = new int[10];

        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                if (counts[s - '0'] < 0) {
                    cows++;
                }

                if (counts[g - '0'] > 0) {
                    cows++;
                }

                counts[s - '0']++;
                counts[g - '0']--;
            }
        }

        return new StringBuilder().append(bulls).append('A').append(cows).append('B').toString();
    }
}
// @lc code=end

