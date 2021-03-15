import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start
class Solution {
    private List<List<String>> solutions = new ArrayList<>();
    private List<String> solution = new ArrayList<>();
    private int n;

    private void solve(int row, int col, int hill, int dale) {
        if (row == n) {
            solutions.add(new ArrayList<>(solution));
        } else {
            char[] cs = new char[n];
            Arrays.fill(cs, '.');

            int valid = ((1 << n) - 1) & ~(col | hill | dale);
            while (valid > 0) {
                int p = valid & -valid;
                int i = (int) (Math.log(p) / Math.log(2));
                valid ^= p;
                
                cs[i] = 'Q';
                solution.add(String.valueOf(cs));
                solve(row + 1, col ^ p, (hill ^ p) << 1, (dale ^ p) >> 1);
                solution.remove(solution.size() - 1);
                cs[i] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        solve(0, 0, 0, 0);

        return solutions;
    }
}
// @lc code=end

