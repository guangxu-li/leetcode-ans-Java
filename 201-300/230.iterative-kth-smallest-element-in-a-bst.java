import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> nodes = new LinkedList<>();

        while (!nodes.isEmpty() || root != null) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }

            root = nodes.pop();
            
            if (--k == 0) {
                return root.val;
            }

            root = root.right;
        }
    }
}
// @lc code=end

