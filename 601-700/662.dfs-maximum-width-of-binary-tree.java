import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=662 lang=java
 *
 * [662] Maximum Width of Binary Tree
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
    private int max = 0;
    private Map<Integer, Integer> levels = new HashMap<>();

    private void dfs(TreeNode root, int depth, int idx) {
        if (root == null) {
            return;
        }

        levels.putIfAbsent(depth, idx);
        max = Math.max(max, idx - levels.get(depth) + 1);
        dfs(root.left, depth + 1, idx * 2);
        dfs(root.right, depth + 1, idx * 2 + 1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 0, 0);    

        return max;
    }
}
// @lc code=end

