/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lo = 0;
        int hi = nums1.length;

        while (lo <= hi) {
            int i = lo + (hi - lo) / 2;
            int j = (nums1.length + nums2.length) / 2 - i;

            if (i > 0 && nums1[i - 1] > nums2[j]) {
                hi = i - 1;
            } else if (i < nums1.length && nums1[i] < nums2[j - 1]) {
                lo = i + 1;
            } else {

                double minRight = 0;

                if (i == nums1.length) {
                    minRight = nums2[j];
                } else if (j == nums2.length) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }

                if (((nums1.length + nums2.length) % 2) != 0) {
                    return minRight;
                }

                double maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                return (maxLeft + minRight) / 2;
            }
        }

        return 0.0;
    }
}
// @lc code=end
