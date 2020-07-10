import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    private List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root, 0);
        Collections.reverse(levels);

        return levels;
    }

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == levels.size()) {
            levels.add(new LinkedList<>());
        }

        levels.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}
// @lc code=end

