/*
 * @lc app=leetcode id=285 lang=java
 *
 * [285] Inorder Successor in BST
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val > p.val) {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        } else {
            return inorderSuccessor(root.right, p);
        }
    }
}
// @lc code=end

