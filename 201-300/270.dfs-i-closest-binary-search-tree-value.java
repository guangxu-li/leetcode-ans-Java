/*
 * @lc app=leetcode id=270 lang=java
 *
 * [270] Closest Binary Search Tree Value
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
    private long prev = Long.MIN_VALUE;
    private Integer candidate = null;
   
    private void dfs(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        
        if (target < root.val) {
            dfs(root.left, target);
        }

        if (candidate != null) {
            return;
        }

        if (root.val > target) {
            candidate = root.val;

            return;
        }

        prev = root.val;
        if (target > root.val) {
            dfs(root.right, target);
        }
    }

    public int closestValue(TreeNode root, double target) {
        dfs(root, target);

        return candidate != null && Math.abs(candidate - target) < Math.abs(prev - target) ? candidate : (int) prev;
    }
}
// @lc code=end

