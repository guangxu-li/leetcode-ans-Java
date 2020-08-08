import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    private List<Integer> values = new ArrayList<>();

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (values.size() == depth) {
            values.add(root.val);
        }

        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);

        return values;
    }
}
// @lc code=end

