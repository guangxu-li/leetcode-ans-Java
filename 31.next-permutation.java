/*
 * @lc app=leetcode id=31 lang=java
 *
 * [31] Next Permutation
 */

// @lc code=lo
class Solution {
    public void nextPermutation(int[] nums) {

        int lo = nums.length - 2;
        while (lo >= 0 && nums[lo] >= nums[lo + 1]) {
            lo--;
        }

        if (lo >= 0) {
            int hi = nextLarger(nums, lo + 1, nums.length - 1);
            swap(nums, lo, hi);
        }
        swapArray(nums, lo + 1);
    }

    public int nextLarger(int[] nums, int start, int end) {
        int target = nums[start - 1];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void swapArray(int[] nums, int start) {
        int lo = start;
        int hi = nums.length - 1;

        while (lo < hi) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }
}
// @lc code=end
