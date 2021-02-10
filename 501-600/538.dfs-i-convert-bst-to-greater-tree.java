/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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
    private int dfs(TreeNode node, int greater) {
        if (node == null) {
            return 0;
        }

        int val = node.val;

        int right = dfs(node.right, greater);
        node.val += greater + right;
        int left = dfs(node.left, node.val);

        return val + left + right;
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);

        return root;
    }
}
// @lc code=end

