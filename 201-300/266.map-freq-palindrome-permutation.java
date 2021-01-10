import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=266 lang=java
 *
 * [266] Palindrome Permutation
 */

// @lc code=start
class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> freqs = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            freqs.put(c, freqs.getOrDefault(c, 0) + 1);
        }

        int count = 0; // how many characters shows odd times
        for (int val : freqs.values()) {
            if (val % 2 == 1) {
                count++;
            }
        }

        return count <= 1;
    }
}
// @lc code=end

