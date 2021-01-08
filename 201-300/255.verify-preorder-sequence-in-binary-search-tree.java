/*
 * @lc app=leetcode id=255 lang=java
 *
 * [255] Verify Preorder Sequence in Binary Search Tree
 */

// @lc code=start
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        int idx = 0;

        for (int val : preorder) {
            if (val < min) {
                return false;
            }

            while (idx >= 1 && val > preorder[idx - 1]) {
                min = preorder[--idx];
            }

            preorder[idx++] = val;
        }

        return true;
    }
}
// @lc code=end

