import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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
    public TreeNode convertBST(TreeNode root) {
        Deque<TreeNode> nodes = new LinkedList<>();
        int sum = 0;
        TreeNode node = root;
        while (!nodes.isEmpty() || node != null) {
            while (node != null) {
                nodes.push(node);
                node = node.right;
            }

            node = nodes.pop();
            sum += node.val;
            node.val = sum;
            node = node.left;
        }

        return root;
    }
}
// @lc code=end

