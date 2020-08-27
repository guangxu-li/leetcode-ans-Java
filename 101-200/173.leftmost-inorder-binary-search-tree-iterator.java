import java.util.ArrayDeque;
import java.util.Deque;
import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
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
class BSTIterator {
    Deque<TreeNode> nodes;

    private void leftmostInorder(TreeNode root) {
        while (root != null) {
            nodes.push(root);
            root = root.left;
        }
    }

    public BSTIterator(TreeNode root) {
        nodes = new ArrayDeque<>();
        leftmostInorder(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = nodes.pop();
        leftmostInorder(node.right);

        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodes.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

