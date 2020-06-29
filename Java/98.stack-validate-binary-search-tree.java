import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    private Deque<TreeNode> stack = new LinkedList<>();
    private Deque<Integer> bound = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        Integer lo = null;
        Integer hi = null;

        updateBound(root, lo, hi);

        while (!stack.isEmpty()) {
            TreeNode tree = stack.pop();
            hi = bound.pop();
            lo = bound.pop();

            if (tree == null) {
                continue;
            }

            int val = tree.val;
            if (lo != null && val <= lo) {
                return false;
            }

            if (hi != null && val >= hi) {
                return false;
            }

            updateBound(tree.left, lo, val);
            updateBound(tree.right, val, hi);
        }

        return true;
    }

    private void updateBound(TreeNode root, Integer lo, Integer hi) {
        stack.push(root);
        bound.push(lo);
        bound.push(hi);
    }
}
// @lc code=end

