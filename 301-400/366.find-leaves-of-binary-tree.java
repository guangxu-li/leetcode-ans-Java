import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=366 lang=java
 *
 * [366] Find Leaves of Binary Tree
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
    private List<List<Integer>> leaves = new ArrayList<>();

    private int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int height = 1 + Math.max(dfs(node.left), dfs(node.right));
        if (height == leaves.size()) {
            leaves.add(new ArrayList<>());
        }        
        leaves.get(height).add(node.val);

        return height;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        return leaves;
    }
}
// @lc code=end

