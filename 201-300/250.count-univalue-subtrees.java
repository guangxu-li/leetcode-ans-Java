/*
 * @lc app=leetcode id=250 lang=java
 *
 * [250] Count Univalue Subtrees
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
    private int count = 0;

    private boolean isValid(TreeNode node, int pVal) {
        if (node == null) {
            return true;
        }

        boolean left = isValid(node.left, node.val);
        boolean right = isValid(node.right, node.val);

        if (!left || !right) {
            return false;
        }

        count++;

        return node.val == pVal;
    }

    public int countUnivalSubtrees(TreeNode root) {
        isValid(root, 0);
        
        return count;
    }
}
// @lc code=end

