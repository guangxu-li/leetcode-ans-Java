/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
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
    private int maxSum = Integer.MIN_VALUE;

    private int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(pathSum(root.left), 0);
        int right = Math.max(pathSum(root.right), 0);

        // new start point of a new path
        maxSum = Math.max(maxSum, root.val + left + right);

        // continue previous path
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }
}
// @lc code=end

