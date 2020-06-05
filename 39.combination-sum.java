import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
    private static List<List<Integer>> ans;

    Solution() {
        ans = new ArrayList<>();
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // Arrays.sort(candidates);

        backtrack(new ArrayList<Integer>(), candidates, 0, target);

        return ans;
    }

    public void backtrack(List<Integer> list, int[] candidates, int idx, int target) {

        for (int i = idx; i < candidates.length; i++) {
            int num = target - candidates[i];

            if (num < 0) {
                continue;
            }

            list.add(candidates[i]);

            if (num == 0) {
                // * found the ans
                ans.add(new ArrayList<>(list));
            } else {
                // * still need more number
                backtrack(list, candidates, i, num);
            }

            list.remove(list.size() - 1);
        }

        return;
    }
}
// @lc code=end
