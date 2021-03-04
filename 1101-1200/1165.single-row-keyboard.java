/*
 * @lc app=leetcode id=1165 lang=java
 *
 * [1165] Single-Row Keyboard
 */

// @lc code=start
class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] mapping = new int[26];
        for (int i = 0; i < 26; i++) {
            char c = keyboard.charAt(i);
            mapping[c - 'a'] = i;
        }
        
        int distance = 0;
        for (int i = 0, prev = 0; i < word.length(); i++) {
            distance += Math.abs(mapping[word.charAt(i) - 'a'] - prev);
            prev = mapping[word.charAt(i) - 'a'];
        }
        
        return distance;
    }
}
// @lc code=end

