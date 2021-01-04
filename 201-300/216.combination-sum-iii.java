import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
    private List<List<Integer>> combos = new ArrayList<>();
    private int n;
    private int k;

    private void dfs(List<Integer> combo, int sum, int pos) {
        if (pos == 10 || combo.size() == k) {
            if (sum != n || combo.size() < k) {
                return;
            }

            combos.add(new ArrayList<>(combo));
        } else {
            dfs(combo, sum, pos + 1);

            if (sum + pos > n) {
                return;
            }

            combo.add(pos);
            dfs(combo, sum + pos, pos + 1);
            combo.remove(combo.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        this.k = k;

        dfs(new ArrayList<>(), 0, 1);

        return combos;
    }
}
// @lc code=end

