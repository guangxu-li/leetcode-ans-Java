import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void dfs(TreeNode node, int distance, int targetDistance, List<Integer> vals,
            Set<TreeNode> visited) {
        if (node == null || visited.contains(node)) {
            return;
        }

        if (distance == targetDistance) {
            vals.add(node.val);
            return;
        }

        dfs(node.left, distance + 1, targetDistance, vals, visited);
        dfs(node.right, distance + 1, targetDistance, vals, visited);
    }

    private boolean getPathToTarget(TreeNode node, TreeNode target, List<TreeNode> nodes) {
        if (node == null) {
            return false;
        }

        nodes.add(node);
        if (node == target) {
            return true;
        }

        if (getPathToTarget(node.left, target, nodes)
                || getPathToTarget(node.right, target, nodes)) {
            return true;
        }

        nodes.remove(nodes.size() - 1);
        return false;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<TreeNode> nodes = new ArrayList<>();
        getPathToTarget(root, target, nodes);

        List<Integer> vals = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        for (int i = 0; i <= Math.min(K, nodes.size() - 1); i++) {
            int idx = nodes.size() - 1 - i;
            TreeNode node = nodes.get(idx);
            dfs(node, 0, K - i, vals, visited);
            visited.add(node);
        }

        return vals;
    }
}
// @lc code=end

