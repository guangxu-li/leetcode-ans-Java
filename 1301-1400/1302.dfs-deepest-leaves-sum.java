/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
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
    private int deepest = 0;
    private int sum = 0;

    private void traverse(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (deepest < depth) {
                deepest = depth;
                sum = node.val;
            } else if (deepest == depth) {
                sum += node.val;
            }
        } else {
            traverse(node.left, depth + 1);
            traverse(node.right, depth + 1);
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        traverse(root, 0);
        
        return sum;
    }
}
// @lc code=end

