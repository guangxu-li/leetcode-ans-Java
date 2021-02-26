/*
 * @lc app=leetcode id=572 lang=java
 *
 * [572] Subtree of Another Tree
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

    private String preorder(TreeNode s) {
        if (s == null) {
            return null;
        }

        return "#" + s.val + preorder(s.left) + preorder(s.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return preorder(s).contains(preorder(t));     
    }
}
// @lc code=end

