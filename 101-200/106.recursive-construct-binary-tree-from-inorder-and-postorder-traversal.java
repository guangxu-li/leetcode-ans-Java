import java.util.HashMap;
import java.util.Map;

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
    private int[] postorder;
    private int postIndex;

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeNode(0, inorder.length - 1);
    }

    private TreeNode buildTreeNode(int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postIndex--]);

        int inIndex = map.get(node.val);

        node.right = buildTreeNode(inIndex + 1, end);
        node.left = buildTreeNode(start, inIndex - 1);

        return node;
    }
}
// @lc code=end

