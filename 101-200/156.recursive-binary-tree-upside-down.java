import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=156 lang=java
 *
 * [156] Binary Tree Upside Down
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
    private TreeNode node = null;

    private void dfs(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            if (node == null) {
                node = root;
            }

            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        upsideDownBinaryTree(root.left);

        left.left = right;
        left.right = root;

        root.left = null;
        root.right = null;

        upsideDownBinaryTree(root);
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        dfs(root);

        return node;
    }
}
// @lc code=end

