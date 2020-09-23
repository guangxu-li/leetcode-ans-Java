import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=987 lang=java
 *
 * [987] Vertical Order Traversal of a Binary Tree
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
    private Map<Integer, List<int[]>> xs = new HashMap<>();
    private int min = 0; // min/max or indice x
    private int max = 0;

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }

        xs.putIfAbsent(x, new ArrayList<>());
        xs.get(x).add(new int[] {root.val, y});

        min = Math.min(min, x);
        max = Math.max(max, x);

        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(xs.get(i).stream().sorted((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1])
                    .map(x -> x[0]).collect(Collectors.toList()));
        }

        return res;
    }
}
// @lc code=end

