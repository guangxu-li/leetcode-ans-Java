import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
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
        Deque<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.push(root);

        List<Integer> values = new ArrayList<Integer>();

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();

            if (node == null) {
                continue;
            }

            values.add(node.val);

            nodes.push(node.right);
            nodes.push(node.left);
        }

        return values;
    }
}
// @lc code=end

