/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validateBST(root, null, null);
    }

    private boolean validateBST(TreeNode root, Integer lo, Integer hi) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (lo != null && val <= lo) {
            return false;
        }

        if (hi != null && val >= hi) {
            return false;
        }

        return validateBST(root.left, lo, val) && validateBST(root.right, val, hi);
    }
}
// @lc code=end

