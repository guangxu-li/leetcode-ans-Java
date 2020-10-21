/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (numbers[lo] + numbers[hi] != target) {
            if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        }

        return new int[] {lo + 1, hi + 1};
    }
}
// @lc code=end

