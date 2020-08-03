import java.util.Random;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    private int partition(int[] nums, int lo, int hi, int pivot) {
        int pivotValue = nums[pivot];
        swap(nums, pivot, hi);

        int j = lo;

        for (int i = lo; i <= hi; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, j++);
            }
        }

        swap(nums, hi, j);

        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        int K = nums.length - k;

        int lo = 0;
        int hi = nums.length - 1;

        Random rand = new Random();
        while (true) {
            if (lo == hi) {
                return nums[lo];
            }

            int pivot = partition(nums, lo, hi, lo + rand.nextInt(hi - lo));
            if (pivot == K) {
                return nums[pivot];
            } else if (pivot < K) {
                lo = pivot + 1;
            } else {
                hi = pivot - 1;
            }
        }
    }
}
// @lc code=end

