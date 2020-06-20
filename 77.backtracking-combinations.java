import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
    private List<List<Integer>> combinations = new ArrayList<>();
    private ArrayList<Integer> combination = new ArrayList<>();
    private int end = 0;
    private int poolSize = 0;

    public List<List<Integer>> combine(int n, int k) {
        this.end = k;
        this.poolSize = n;

        backtrack(0);

        return combinations;
    }

    private void backtrack(int pos) {
        if (combination.size() == end) {
            combinations.add(new ArrayList<>(combination));
        } else {
            for (int i = pos; i <= poolSize - (end - combination.size()); i++) {
                combination.add(i + 1);
                backtrack(i + 1);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
// @lc code=end

