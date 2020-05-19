/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1, mm = m - 1, nn = n - 1; i >= 0; i--) {
            nums1[i] = mm >= 0 && (nn < 0 || nums1[mm] >= nums2[nn]) ? nums1[mm--] : nums2[nn--];
        }
    }
}
// @lc code=end
