import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
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
    private List<Integer> vals = new ArrayList<>();

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }

        dfs(node.left);
        vals.add(node.val);
        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);

        return vals.get(k - 1);
    }
}
// @lc code=end

