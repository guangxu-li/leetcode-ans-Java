import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();

        if (root == null) {
            return paths;
        }

        Deque<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);
        Deque<Integer> sums = new ArrayDeque<>();
        sums.push(0);
        Deque<List<Integer>> pathStack = new LinkedList<>();
        pathStack.push(new ArrayList<>());

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int curSum = sums.pop();
            List<Integer> path = pathStack.pop();

            if (node == null) {
                continue;
            }
            path.add(node.val);

            curSum += node.val;
            if (node.left == null && node.right == null) {
                if (curSum == sum) {
                    paths.add(path);
                }
            }

            nodes.push(node.right);
            sums.push(curSum);
            pathStack.push(new ArrayList<>(path));

            nodes.push(node.left);
            sums.push(curSum);
            pathStack.push(new ArrayList<>(path));
        }

        return paths;
    }
}
// @lc code=end

