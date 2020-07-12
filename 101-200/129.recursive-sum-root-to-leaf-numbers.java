/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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

    private void dfs(TreeNode root, int num) {
        if (root == null) {
            return;
        }

        num += root.val;

        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }

        dfs(root.left, num * 10);
        dfs(root.right, num * 10);
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);

        return sum;
    }
}
// @lc code=end

