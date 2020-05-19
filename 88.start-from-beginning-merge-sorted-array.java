import java.util.Arrays;

/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = Arrays.copyOf(nums1, nums1.length);

        for (int i = 0, mm = 0, nn = 0; i < m + n; i++) {
            nums1[i] = (mm < m && (nn >= n || nums1Copy[mm] <= nums2[nn])) ? nums1Copy[mm++] : nums2[nn++];
        }
    }
}
// @lc code=end
