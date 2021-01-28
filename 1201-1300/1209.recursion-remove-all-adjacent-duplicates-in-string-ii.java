/*
 * @lc app=leetcode id=1209 lang=java
 *
 * [1209] Remove All Adjacent Duplicates in String II
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s, int k) {
        for (int i = 1, count = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;

                if (count == k) {
                    return removeDuplicates(s.substring(0, i - k + 1) + s.substring(i + 1), k);
                }
            } else {
                count = 1;
            }
        }

        return s;
    }
}
// @lc code=end

