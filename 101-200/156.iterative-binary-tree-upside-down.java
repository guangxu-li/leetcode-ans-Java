import java.util.Deque;
import java.util.LinkedList;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=156 lang=java
 *
 * [156] Binary Tree Upside Down
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode newRoot = null;
        Deque<TreeNode> nodes = new LinkedList<>();

        TreeNode node = root;
        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }

            node = nodes.pop();
            TreeNode left = node.left;
            TreeNode right = node.right;

            if (node.left == null && node.right == null) {
                if (newRoot == null) {
                    newRoot = node;
                }
            } else {
                left.left = right;
                left.right = node;

                node.left = null;
                node.right = null;
            }

            node = right;
        }

        return newRoot;
    }
}
// @lc code=end

