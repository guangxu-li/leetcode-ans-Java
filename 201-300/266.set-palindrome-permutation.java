import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=266 lang=java
 *
 * [266] Palindrome Permutation
 */

// @lc code=start
class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> odds =new HashSet<>();

        for (char c : s.toCharArray()) {
            if (!odds.add(c)) {
                odds.remove(c);
            }
        }

        return odds.size() <= 1;
    }
}
// @lc code=end

