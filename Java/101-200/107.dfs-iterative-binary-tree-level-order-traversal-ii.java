import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        Deque<Integer> depth = new ArrayDeque<>();
        depth.push(0);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int level = depth.pop();

            if (node != null) {
                if (level == levels.size()) {
                    levels.add(new LinkedList<>());
                }

                levels.get(level).add(node.val);

                stack.push(node.right);
                depth.push(level + 1);
                stack.push(node.left);
                depth.push(level + 1);
            }
        }

        Collections.reverse(levels);

        return levels;
    }
}
// @lc code=end

