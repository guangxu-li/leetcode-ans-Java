/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    private TreeNode x;
    private TreeNode y;
    private TreeNode prev;
    private boolean finished = false;

    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);

        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    private void findTwoSwapped(TreeNode root) {
        if (root != null && !finished) {
            findTwoSwapped(root.left);

            if (!finished && (prev != null && prev.val > root.val)) {
                y = root;

                if (x == null) {
                    x = prev;
                } else {
                    finished = true;
                }
            }

            prev = root;
            findTwoSwapped(root.right);
        }
    }
}
// @lc code=end

