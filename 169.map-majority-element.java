/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cnts = new HashMap<>();

        for (int num : nums) {
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);

            if (cnts.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
}
// @lc code=end

