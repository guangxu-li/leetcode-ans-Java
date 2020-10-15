/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */

// @lc code=start
class Solution {
    private void countSort(int[] nums, int exp) {
        int[] count = new int[10];

        for (int num : nums) {
            count[(num / exp) % 10]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] sorted = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sorted[--count[(nums[i] / exp) % 10]] = nums[i];
        }

        for (int i = 0; i < sorted.length; i++) {
            nums[i] = sorted[i];
        }
    }

    private void radixSort(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(nums, exp);
        }
    }

    public int maximumGap(int[] nums) {
        radixSort(nums);

        int maxGap = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }

        return maxGap;
    }
}
// @lc code=end

