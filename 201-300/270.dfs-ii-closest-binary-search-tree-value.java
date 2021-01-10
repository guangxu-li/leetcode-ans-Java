import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=270 lang=java
 *
 * [270] Closest Binary Search Tree Value
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
    public int closestValue(TreeNode root, double target) {
        Deque<TreeNode> nodes = new LinkedList<>();

        long prev = Long.MIN_VALUE;

        while (!nodes.isEmpty() || root != null) {
            while (root != null) {
                nodes.push(root);
                root = root.left;
            }

            root = nodes.pop();

            if (root.val > target) {
                return Math.abs(prev - target) < Math.abs(root.val - target) ? (int) prev : root.val;
            }

            prev = root.val;
            root = root.right;
        }

        return (int) prev;
    }
}
// @lc code=end

