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

    private boolean isUni(TreeNode node) {
        if (node.left == null && node.right == null) {
            count++;

            return true;
        }

        boolean isUni = true;

        if (node.left != null) {
            isUni &= isUni(node.left) && node.left.val == node.val;
        }

        if (node.right != null) {
            isUni &= isUni(node.right) && node.right.val == node.val;
        }

        if (isUni) {
            count++;

            return true;
        } else {
            return false;
        }
    }

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }        

        isUni(root);

        return count;
    }
}
// @lc code=end

