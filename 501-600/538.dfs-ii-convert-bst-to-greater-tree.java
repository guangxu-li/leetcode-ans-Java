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
    private int sum = 0;

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return node;
        }

        dfs(node.right);
        sum += node.val;
        node.val = sum;
        dfs(node.left);

        return node;
    }

    public TreeNode convertBST(TreeNode root) {
        return dfs(root);        
    }
}
// @lc code=end

