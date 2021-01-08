import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    private List<String> paths = new ArrayList<>();

    private void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }

        path += String.valueOf(root.val);

        if (root.left == null && root.right == null) {
            paths.add(path);
        } else {
            path += "->";
            dfs(root.left, path);
            dfs(root.right, path);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");

        return paths;
    }
}
// @lc code=end

