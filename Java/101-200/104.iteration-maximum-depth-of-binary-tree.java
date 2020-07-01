import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> depth = new ArrayDeque<>();

        stack.push(root);
        depth.push(0);

        int maxDepth = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int level = depth.pop();

            if (node == null) {
                maxDepth = Math.max(maxDepth, level);
            } else {
                stack.push(node.right);
                depth.push(level + 1);
                stack.push(node.left);
                depth.push(level + 1);
            }
        }

        return maxDepth;
    }
}
// @lc code=end

