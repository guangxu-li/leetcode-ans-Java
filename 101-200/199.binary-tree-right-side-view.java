import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        List<Integer> values = new ArrayList<>();

        int depth = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();

            while (size-- > 0) {
                TreeNode node = nodes.poll();

                if (node == null) {
                    continue;
                }

                if (values.size() == depth) {
                    values.add(node.val);
                }

                nodes.add(node.right);
                nodes.add(node.left);
            }

            depth++;
        }

        return values;
    }
}
// @lc code=end

