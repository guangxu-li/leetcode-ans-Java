/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] counts = new int[10];

        for (char c : secret.toCharArray()) {
            counts[c - '0']++;
        }

        boolean[] bulled = new boolean[guess.length()];
        for (int i = 0; i < guess.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                counts[s - '0']--;
                bulls++;
                bulled[i] = true;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);

            if (bulled[i] || counts[g - '0'] == 0) {
                continue;
            }

            counts[g - '0']--;
            cows++;
        }

        return bulls + "A" + cows + "B";
    }
}
// @lc code=end

