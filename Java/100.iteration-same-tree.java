import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else if (q == null) {
            return false;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()) {

            // p = stack.pop() ?
            TreeNode Q = stack.pop();
            TreeNode P = stack.pop();

            if (P.val != Q.val) {
                return false;
            }

            if (!check(P.right, Q.right)) {
                return false;
            }

            if (P.right != null) {
                stack.push(P.right);
                stack.push(Q.right);
            }

            if (!check(P.left, Q.left)) {
                return false;
            }

            if (P.left != null) {
                stack.push(P.left);
                stack.push(Q.left);
            }
        }

        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return true;
        }
    }
}
// @lc code=end

