import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> nodes = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        nodes.push(null);
        nodes.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = nodes.pop();
            TreeNode prev = nodes.pop();

            if (node == null) {
                continue;
            }

            parent.put(node, prev);

            nodes.push(node);
            nodes.push(node.right);
            nodes.push(node);
            nodes.push(node.left);
        }

        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode node = p;

        while (node != null) {
            ancestors.add(node);
            node = parent.get(node);
        }

        node = q;
        while (!ancestors.contains(node)) {
            node = parent.get(node);
        }

        return node;
    }
}
// @lc code=end

