/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        int inIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]); // The node that is going to be inserted
            TreeNode position = stack.peek(); // It denotes where to insert the node 

            while (!stack.isEmpty() && stack.peek().val == inorder[inIndex]) {
                position = stack.pop();
                inIndex++;
            }

            if (position == stack.peek()) {
                position.left = node;
            } else {
                position.right = node;
            }

            stack.push(node);
        }

        return root;
    }
}
// @lc code=end

