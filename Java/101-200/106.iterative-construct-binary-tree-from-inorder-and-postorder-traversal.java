import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        stack.push(root);

        int inIndex = inorder.length - 1;

        for (int i = postorder.length - 2; i >= 0; i--) {
            TreeNode node = new TreeNode(postorder[i]);
            TreeNode position = stack.peek();

            while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
                position = stack.pop();
                inIndex--;
            }

            if (position == stack.peek()) {
                position.right = node;
            } else {
                position.left = node;
            }

            stack.push(node);
        }

        return root;
    }
}
// @lc code=end

