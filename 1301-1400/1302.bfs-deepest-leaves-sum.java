import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=1302 lang=java
 *
 * [1302] Deepest Leaves Sum
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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int sum = 0;

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            sum = 0;

            while (size-- > 0) {
                TreeNode node = nodes.poll();
                sum += node.val;

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }

        return sum;
    }
}
// @lc code=end

