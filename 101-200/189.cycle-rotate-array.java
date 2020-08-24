/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = nums.length;

        for (int start = 0; count > 0; start++) {
            int cur = start;
            int prev = nums[cur];

            do {
                cur = (cur + k) % nums.length;
                int next = nums[cur];
                nums[cur] = prev;
                prev = next;

                count--;
            } while (start != cur);
        }
    }
}
// @lc code=end

