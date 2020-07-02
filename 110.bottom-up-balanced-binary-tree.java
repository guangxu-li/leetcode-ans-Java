/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);

        if (left < 0) {
            return -1;
        }

        int right = getHeight(root.right);

        if (right < 0) {
            return -1;
        }

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    public boolean isBalanced(TreeNode root) {

        // if it's not balanced, it returns -1
        return getHeight(root) >= 0;
    }
}
// @lc code=end

