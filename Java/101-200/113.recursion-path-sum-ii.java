import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    private List<List<Integer>> paths = new ArrayList<>();

    private void dfs(TreeNode root, int sum, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                paths.add(new ArrayList<>(path));
            }
        }

        dfs(root.left, sum - root.val, path);
        dfs(root.right, sum - root.val, path);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());

        return paths;
    }
}
// @lc code=end

