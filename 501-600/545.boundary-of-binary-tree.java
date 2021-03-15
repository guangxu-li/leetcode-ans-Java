import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=545 lang=java
 *
 * [545] Boundary of Binary Tree
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
    private List<Integer> boundary = new ArrayList<>();

    private void rightBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        if (node.right != null) {
            rightBoundary(node.right);
        } else {
            rightBoundary(node.left);
        }
        boundary.add(node.val);
    }

    private void leftBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }

        boundary.add(node.val);
        if (node.left != null) {
            leftBoundary(node.left);
        } else {
            leftBoundary(node.right);
        }
    }

    private void leaves(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            boundary.add(node.val);
            return;
        }

        leaves(node.left);
        leaves(node.right);
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        boundary.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return boundary;
    }
}
// @lc code=end
