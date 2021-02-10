import java.util.LinkedList;
import java.util.Queue;

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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Long> positions = new LinkedList<>();

        nodes.add(root);
        positions.add(0l);

        long max = 0;

        while (!nodes.isEmpty()) {
            long size = nodes.size();

            long lo = -1;
            long hi = -2;

            while (size-- > 0) {
                TreeNode node = nodes.poll();
                long position = positions.poll();

                if (node == null) {
                    continue;
                }

                lo = lo == -1 ? position : lo;
                hi = Math.max(hi, position);

                nodes.add(node.left);
                nodes.add(node.right);

                positions.add(position * 2);
                positions.add(position * 2 + 1);
            }

            max = Math.max(max, hi - lo + 1);
        }

        return (int) max;
    }
}
// @lc code=end


