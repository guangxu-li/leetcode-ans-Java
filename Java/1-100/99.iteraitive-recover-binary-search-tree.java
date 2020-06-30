import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
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
    public void recoverTree(TreeNode root) {
        TreeNode x = null;
        TreeNode y = null;
        TreeNode prev = null;

        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (prev != null && prev.val > root.val) {
                y = root;

                if (x == null) {
                    x = prev;
                } else {
                    break;
                }
            }

            prev = root;
            root = root.right;
        }

        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
// @lc code=end

