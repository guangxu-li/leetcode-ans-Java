/*
 * @lc app=leetcode id=1461 lang=java
 *
 * [1461] Check If a String Contains All Binary Codes of Size K
 */

// @lc code=start
class Solution {
    public boolean hasAllCodes(String s, int k) {
        int cnt = 1 << k;
        int mask = cnt - 1;
        int[] found = new int[cnt];

        for (int i = 0, hash = 0; i < s.length(); i++) {
            hash = (hash << 1) & mask | (s.charAt(i) - '0');
            if (found[hash] == 0) {
                cnt--;
            }
            found[hash]++;

            if (cnt == 0) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

