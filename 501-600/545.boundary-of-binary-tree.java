import java.util.ArrayList;
import java.util.Collections;
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
    private List<Integer> left = new ArrayList<>();
    private List<Integer> right = new ArrayList<>();
    private List<Integer> leaf = new ArrayList<>();

    private void dfs(TreeNode node, boolean normal, boolean isLeft) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leaf.add(node.val);

            return;
        }

        if (normal) {
            dfs(node.left, normal, isLeft);
            dfs(node.right, normal, isLeft);
        } else if (isLeft) {
            left.add(node.val);

            dfs(node.left, false, isLeft);
            dfs(node.right, node.left != null, isLeft);
        } else {
            right.add(node.val);

            dfs(node.left, node.right != null, isLeft);
            dfs(node.right, false, isLeft);
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        boundary.add(root.val);

        dfs(root.left, false, true);
        dfs(root.right, false, false);

        Collections.reverse(right);

        boundary.addAll(left);
        boundary.addAll(leaf);
        boundary.addAll(right);

        return boundary;
    }
}
// @lc code=end

