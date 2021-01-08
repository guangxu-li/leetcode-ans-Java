import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        Deque<TreeNode> nodes = new LinkedList<>(){{add(root);}};
        Deque<String> ps = new ArrayDeque<>(){{add("");}};

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            String path = ps.pop();

            if (node == null) {
                continue;
            }

            path += String.valueOf(node.val);

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                path += "->";

                nodes.push(node.right);
                ps.push(path);
                nodes.push(node.left);
                ps.push(path);
            }
        }

        return paths;
    }
}
// @lc code=end

