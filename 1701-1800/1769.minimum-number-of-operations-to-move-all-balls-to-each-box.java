/*
 * @lc app=leetcode id=1769 lang=java
 *
 * [1769] Minimum Number of Operations to Move All Balls to Each Box
 */

// @lc code=start
class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] moves = new int[n];

        for (int i = 0, ops = 0, cnt = 0; i < n; i++) {
            moves[i] += ops;
            cnt += boxes.charAt(i) - '0';
            ops += cnt;
        }

        for (int i = n - 1, ops = 0, cnt = 0; i >= 0; i--) {
            moves[i] += ops;
            cnt += boxes.charAt(i) - '0';
            ops += cnt;
        }

        return moves;
    }
}
// @lc code=end

