import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        Deque<Integer> height = new ArrayDeque<>();
        height.push(1);

        int minDepth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = height.pop();

            if (node.left == null && node.right == null) {
                minDepth = Math.min(minDepth, depth);
            }

            if (node.right != null) {
                stack.push(node.right);
                height.push(depth + 1);
            }

            if (node.left != null) {
                stack.push(node.left);
                height.push(depth + 1);
            }
        }

        return minDepth;
    }
}
// @lc code=end

