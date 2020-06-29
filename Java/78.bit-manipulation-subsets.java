import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> combinations = new ArrayList<>();

        int i = 0;
        while (i <= (1 << nums.length) - 1) {
            List<Integer> combination = new ArrayList<>();

            int candidates = i;
            while (candidates > 0) {
                int p = candidates & -candidates;
                int idx = (int) (Math.log(p) / Math.log(2));
                candidates ^= p;

                combination.add(nums[idx]);
            }

            combinations.add(combination);
            i++;
        }
        return combinations;
    }
}
// @lc code=end

