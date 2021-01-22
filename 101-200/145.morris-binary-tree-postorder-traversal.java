import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> vals = new LinkedList<>();

        while (root != null) {
            if (root.right == null) {
                vals.push(root.val);
                root = root.left;
            }  else {
                TreeNode leftMost = root.right;
                while (leftMost.left != null && leftMost.left != root) {
                    leftMost = leftMost.left;
                }

                if (leftMost.left == null) {
                    vals.push(root.val);
                    leftMost.left = root;
                    root = root.right;
                } else {
                    leftMost.left = null;
                    root = root.left;
                }
            }
        }

        return vals;
    }
}
// @lc code=end

