import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    private List<Integer> combination = new ArrayList<>();
    private List<List<Integer>> combinations = new ArrayList<>();
    private int k = 0;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        for (int i = 0; i <= nums.length; i++) {
            this.k = i;

            backtrack(0);
        }

        return combinations;
    }

    private void backtrack(int pos) {
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
        } else {
            for (int i = pos; i <= nums.length - (k - combination.size()); i++) {
                combination.add(nums[i]);
                backtrack(i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
// @lc code=end

