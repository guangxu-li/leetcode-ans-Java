import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);
        Deque<Integer> sums = new ArrayDeque<>();
        sums.push(0);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int curSum = sums.pop();

            if (node == null) {
                continue;
            }

            curSum += node.val;
            if (node.left == null && node.right == null) {
                if (curSum == sum) {
                    return true;
                }
            }

            nodes.push(node.right);
            sums.push(curSum);
            nodes.push(node.left);
            sums.push(curSum);
        }

        return false;
    }
}
// @lc code=end

