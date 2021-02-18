import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> nodes = new LinkedList<>();
        TreeNode cmnAncstr = null;

        while (!nodes.isEmpty() || root != null) {
            while (root != null) {
                if (root.right != null) { /* in case node.right == null at line +9 */
                    nodes.push(root.right);
                }
                nodes.push(root);
                root = root.left;
            }

            TreeNode node = nodes.pop();
            if (cmnAncstr != null && (node.left == cmnAncstr || node.right == cmnAncstr)) {
                cmnAncstr = node;
            }

            if (!nodes.isEmpty() && node.right == nodes.peek()) {
                root = nodes.pop();
                nodes.push(node);
            } else if (node == p || node == q) {
                if (cmnAncstr == null) {
                    cmnAncstr = node;
                } else {
                    break;
                }
            }
        }

        return cmnAncstr;
    }
}
// @lc code=end

