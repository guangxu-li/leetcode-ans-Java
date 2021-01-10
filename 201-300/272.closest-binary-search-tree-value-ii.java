import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode id=272 lang=java
 *
 * [272] Closest Binary Search Tree Value II
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
    private List<Integer> vals = new ArrayList<>();
    private double target;

    private double distance(int i) {
        return Math.abs(vals.get(i) - target);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        vals.add(root.val);
        inorder(root.right);
    }

    private int partition(int lo, int hi, int pivot) {
        double pivotVal = distance(pivot);
        Collections.swap(vals, pivot, hi);
        
        int j = lo;
        for (int i = lo; i <= hi; i++) {
            if (distance(i) < pivotVal) {
                Collections.swap(vals, i, j++);
            }
        }

        Collections.swap(vals, j, hi);

        return j;
    }

    private void quickselect(int lo, int hi, int k) {
        if (lo >= hi) {
            return;
        }

        Random rand = new Random();
        int pivot = partition(lo, hi, lo + rand.nextInt(hi - lo));

        if (pivot == k) {
            return;
        } else if (k < pivot) {
            quickselect(lo, pivot - 1, k);
        } else {
            quickselect(pivot + 1, hi, k);
        }
    }


    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        this.target = target;
        inorder(root);
        quickselect(0, vals.size() - 1, k);

        return vals.subList(0, k);
    }
}
// @lc code=end

