/*
 * @lc app=leetcode id=298 lang=java
 *
 * [298] Binary Tree Longest Consecutive Sequence
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
    private int max = 0;

    private void dfs(TreeNode root, int count) {
        max = Math.max(max, count);

        if (root.left != null) {
            dfs(root.left, root.left.val == root.val + 1 ? count + 1 : 1);
        }

        if (root.right != null) {
            dfs(root.right, root.right.val == root.val + 1 ? count + 1 : 1);
        }
    }

    public int longestConsecutive(TreeNode root) {
        if (root != null) {
            dfs(root, 1);        
        }

        return max;
    }
}
// @lc code=end

