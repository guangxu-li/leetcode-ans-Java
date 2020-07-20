import java.util.Deque;
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
        Deque<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.push(root);

        LinkedList<Integer> values = new LinkedList<Integer>();

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();

            if (node == null) {
                continue;
            }

            values.push(node.val);
            nodes.push(node.left);
            nodes.push(node.right);
        }

        return values;
    }
}
// @lc code=end

