import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            nums.add(i);
        }
        nums.add(n + 1);

        int j = 0;
        List<List<Integer>> combinations = new ArrayList<>();
        while (j < k) {
            combinations.add(new ArrayList<>(nums.subList(0, k)));

            j = 0;
            while (j < k && nums.get(j + 1) == nums.get(j) + 1) {
                nums.set(j, j++ + 1);
            }
            nums.set(j, nums.get(j) + 1);
        }

        return combinations;
    }
}
// @lc code=end

