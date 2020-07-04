/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 */

// @lc code=start
/**
 * Definition for a binary tree root.
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        while (root != null) {
            if (root.left != null) {
                if (root.right != null) {
                    TreeNode rightMost = root.left;
                    while (rightMost.right != null) {
                        rightMost = rightMost.right;
                    }

                    rightMost.right = root.right;
                }

                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }
}
// @lc code=end

