import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=508 lang=java
 *
 * [508] Most Frequent Subtree Sum
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
    private int max = 0;
    private Map<Integer, Integer> cnts = new HashMap<>();

    private int calculate(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + calculate(root.left) + calculate(root.right);
        cnts.put(sum, cnts.getOrDefault(sum, 0) + 1);
        max = Math.max(max, cnts.get(sum));

        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        calculate(root); 

        List<Integer> treeSums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cnts.entrySet()) {
            if (entry.getValue() == max) {
                treeSums.add(entry.getKey());
            }
        }

        return treeSums.stream().mapToInt(i -> i).toArray();
    }
}
// @lc code=end

