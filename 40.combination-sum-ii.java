import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrack(new ArrayList<Integer>(), candidates, 0, target);

        return ans;
    }

    public void backtrack(List<Integer> list, int[] candidates, int offset, int target) {
        for (int i = offset; i < candidates.length; i++) {
            int num = target - candidates[i];
            if (num < 0) {
                break;
            }

            if (i > offset && candidates[i - 1] == candidates[i]) {
                continue;
            }

            list.add(candidates[i]);
            if (num == 0) {
                ans.add(new ArrayList<>(list));
            } else {
                backtrack(list, candidates, i + 1, num);
            }
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end
