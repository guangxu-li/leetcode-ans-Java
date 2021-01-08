import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=254 lang=java
 *
 * [254] Factor Combinations
 */

// @lc code=start
class Solution {
    private List<List<Integer>> combos = new ArrayList<>();
    private List<Integer> combo = new ArrayList<>();

    private void helper(int n, int cur) {
        if (n <= 1) {
            if (combo.size() <= 1) {
                return;
            }
            combos.add(new ArrayList<>(combo));
        } else {
            int bound = (int) Math.sqrt(n);
            for (int i = cur; i <= bound; i++) {
                if (n % i == 0) {
                    combo.add(i);
                    helper(n / i, i);
                    combo.remove(combo.size() - 1);
                }
            }

            combo.add(n);
            helper(1, n);
            combo.remove(combo.size() - 1);
        }
    }

    public List<List<Integer>> getFactors(int n) {
        helper(n, 2);

        return combos;
    }
}
// @lc code=end

