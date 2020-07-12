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
        int num = 0;
        int step = 0;

        while (root != null) {
            if (root.left != null) {
                TreeNode rightMost = root.left;
                step = 1;

                while (rightMost.right != null && rightMost.right != root) {
                    rightMost = rightMost.right;
                    step++;
                }

                if (rightMost.right == null) {
                    num = num * 10 + root.val;
                    rightMost.right = root;
                    root = root.left;
                } else {
                    if (rightMost.left == null) {
                        sum += num;
                    }

                    for (int i = 0; i < step; i++) {
                        num /= 10;
                    }

                    rightMost.right = null;
                    root = root.right;
                }
            } else {
                num = num * 10 + root.val;

                if (root.right == null) {
                    sum += num;
                }

                root = root.right;
            }
        }

        return sum;
    }
}
// @lc code=end
