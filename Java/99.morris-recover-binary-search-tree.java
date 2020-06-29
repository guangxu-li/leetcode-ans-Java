/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        TreeNode x = null;
        TreeNode y = null;
        TreeNode prev = null;

        while (root != null) {
            if (root.left != null) {
                TreeNode rightMost = root.left;
                while (rightMost.right != null && rightMost.right != root) {
                    rightMost = rightMost.right;
                }

                if (rightMost.right != root) {
                    rightMost.right = root;
                    root = root.left;
                } else {
                    rightMost.right = null;

                    if (prev != null && prev.val > root.val) {
                        y = root;

                        if (x == null) {
                            x = prev;
                        } /* don't break! need to continue to restore the link structure*/
                    }

                    prev = root;
                    root = root.right;
                }
            } else {
                if (prev != null && prev.val > root.val) {
                    y = root;

                    if (x == null) {
                        x = prev;
                    } /* don't break! need to continue to restore the link structure*/
                }

                prev = root;
                root = root.right;
            }
        }

        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
// @lc code=end

