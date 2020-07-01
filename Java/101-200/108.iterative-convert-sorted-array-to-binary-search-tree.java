import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        Deque<Integer> idxStack = new ArrayDeque<>();
        idxStack.push(0);
        idxStack.push(nums.length - 1);

        Deque<TreeNode> nodeStack = new LinkedList<>();
        TreeNode root = new TreeNode(0);
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            int hi = idxStack.pop();
            int lo = idxStack.pop();
            TreeNode node = nodeStack.pop();

            int mid = (lo + hi) / 2;
            node.val = nums[mid];

            if (mid + 1 <= hi) {
                node.right = new TreeNode(0);
                nodeStack.push(node.right);
                idxStack.push(mid + 1);
                idxStack.push(hi);
            }

            if (lo <= mid - 1) {
                node.left = new TreeNode(0);
                nodeStack.push(node.left);
                idxStack.push(lo);
                idxStack.push(mid - 1);
            }
        }

        return root;
    }
}
// @lc code=end

