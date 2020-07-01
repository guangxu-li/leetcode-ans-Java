import java.util.HashMap;
import java.util.Map;
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
    private int[] preorder;
    private int preIndex = 0;

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeNode(0, inorder.length - 1);
    }

    private TreeNode buildTreeNode(int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preIndex++]);

        int inIndex = map.get(node.val);

        node.left = buildTreeNode(start, inIndex - 1);
        node.right = buildTreeNode(inIndex + 1, end);

        return node;
    }
}
// @lc code=end

