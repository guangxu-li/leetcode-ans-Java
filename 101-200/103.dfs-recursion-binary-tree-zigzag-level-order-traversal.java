import java.util.ArrayList;
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
    private List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        bfs(root, 0);

        return levels;
    }

    private void bfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (level == levels.size()) {
            levels.add(new LinkedList<>());
        }

        LinkedList<Integer> vals = (LinkedList<Integer>) levels.get(level);
        if (level % 2 == 0) {
            vals.addLast(root.val);
            // levels.get(level).addLast(root.val);
        } else {
            vals.addFirst(root.val);
            // levels.get(level).addFirst(root.val);
        }

        bfs(root.left, level + 1);
        bfs(root.right, level + 1);
    }
}
// @lc code=end

