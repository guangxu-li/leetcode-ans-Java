import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();

        while (root != null) {
            values.add(root.val);

            if (root.left != null) {
                TreeNode rightMost = root.left;

                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }

                rightMost.right = root.right;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return values;
    }
}
// @lc code=end

