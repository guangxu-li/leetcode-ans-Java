import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
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
    private List<TreeNode>[][] cache;

    public List<TreeNode> generateTrees(int n) {
        this.cache = new ArrayList[n + 1][n + 1];

        return n == 0 ? new ArrayList<>() : generateBinaryTree(1, n);
    }

    private List<TreeNode> generateBinaryTree(int lo, int hi) {
        List<TreeNode> nodes = new ArrayList<>();

        if (cache[lo - 1][hi] != null) {
            return cache[lo - 1][hi];
        }

        if (lo > hi) {
            nodes.add(null);
        } else {
            for (int i = lo; i <= hi; i++) {
                List<TreeNode> leftTree = generateBinaryTree(lo, i - 1);
                List<TreeNode> rightTree = generateBinaryTree(i + 1, hi);

                for (TreeNode left : leftTree) {
                    for (TreeNode right : rightTree) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        nodes.add(root);
                    }
                }
            }
        }

        cache[lo - 1][hi] = nodes;
        return nodes;
    }
}
// @lc code=end

