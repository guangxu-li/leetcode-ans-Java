import java.util.ArrayList;
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
        List<Integer> values = new ArrayList<Integer>();

        while (root != null || !nodes.isEmpty()) {
            while (root != null) {
                nodes.push(root.right);
                nodes.push(root);

                root = root.left;
            }

            root = nodes.pop();
            if (root == null) {
                continue;
            }

            if (!nodes.isEmpty() && root.right == nodes.peek()) {
                nodes.pop();
                nodes.push(root);
                root = root.right;
            } else {
                values.add(root.val);
                root = null;
            }
        }

        return values;
    }
}
// @lc code=end

