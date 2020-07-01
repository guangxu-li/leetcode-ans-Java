import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        int level = 0;
        nodeStack.push(root);
        numStack.push(level);

        List<List<Integer>> levels = new ArrayList<>();

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            level = numStack.pop();

            if (node != null) {
                if (level == levels.size()) {
                    levels.add(new LinkedList<>());
                }

                LinkedList<Integer> vals = (LinkedList<Integer>) levels.get(level);
                if (level % 2 == 0) {
                    vals.addLast(node.val);
                } else {
                    vals.addFirst(node.val);
                }

                nodeStack.push(node.right);
                numStack.push(level + 1);

                nodeStack.push(node.left);
                numStack.push(level + 1);
            }
        }

        return levels;
    }
}
// @lc code=end

