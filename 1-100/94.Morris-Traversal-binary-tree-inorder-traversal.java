import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new ArrayList<>();

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                vals.add(node.val);
                node = node.right;
            } else {
                TreeNode rightMost = node.left;
                while (rightMost.right != null && rightMost.right != node) {
                    rightMost = rightMost.right;
                }

                if (rightMost.right == null) {
                    rightMost.right = node;
                    node = node.left;
                } else {
                    rightMost.right = null;
                    vals.add(node.val);
                    node = node.right;
                }
            }
        }

        return vals;
    }
}
// @lc code=end

