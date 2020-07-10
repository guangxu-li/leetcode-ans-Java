import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> solution = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target);

        return ans;
    }

    public void backtrack(int[] candidates, int pos, int target) {

        for (int i = pos; i < candidates.length; i++) {
            int num = target - candidates[i];

            if (num < 0) {
                continue;
            }

            solution.add(candidates[i]);

            if (num == 0) {
                ans.add(new ArrayList<>(solution));
            } else {
                backtrack(candidates, i, num);
            }

            solution.remove(solution.size() - 1);
        }
    }
}
// @lc code=end
