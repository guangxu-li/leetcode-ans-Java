import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> nodes = new LinkedList<TreeNode>();
        Deque<Integer> nums = new ArrayDeque<Integer>();
        nodes.push(root);
        nums.push(0);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            int num = nums.pop();

            if (node == null) {
                continue;
            }

            num += node.val;
            if (node.left == null && node.right == null) {
                sum += num;
                continue;
            }

            nodes.push(node.right);
            nums.push(num * 10);
            nodes.push(node.left);
            nums.push(num * 10);
        }

        return sum;
    }
}
// @lc code=end

