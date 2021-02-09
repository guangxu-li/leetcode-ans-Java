import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=863 lang=java
 *
 * [863] All Nodes Distance K in Binary Tree
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
    Map<TreeNode, TreeNode> parents = new HashMap<>();

    private void annoteParents(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }

        parents.put(node, parent);
        annoteParents(node.left, node);
        annoteParents(node.right, node);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        annoteParents(root, null);

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(target);
        Set<TreeNode> visited = new HashSet<>();

        int distance = 0;
        List<Integer> vals = new ArrayList<>();
        while (!nodes.isEmpty() && distance <= K) {
            int size = nodes.size();
            while (size-- > 0) {
                TreeNode node = nodes.poll();
                if (node == null || visited.contains(node)) {
                    continue;
                }
                visited.add(node);

                if (distance == K) {
                    vals.add(node.val);
                } else {
                    nodes.add(node.left);
                    nodes.add(node.right);
                    nodes.add(parents.get(node));
                }
            }

            distance++;
        }

        return vals;
    }
}
// @lc code=end

