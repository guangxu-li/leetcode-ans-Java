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
    private int SIZE;

    private List<String> solution = new ArrayList<>();
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        SIZE = n;
        backtrack(0, 0, 0, 0);

        return ans;
    }

    public void backtrack(int n, int col, int hill, int dale) {
        if (n == SIZE) {
            ans.add(new ArrayList<>(solution));
        } else {
            char[] charArray = new char[SIZE];
            Arrays.fill(charArray, '.');

            int validPoints = ((1 << SIZE) - 1) & ~(col | hill | dale);

            while (validPoints != 0) {
                int p = validPoints & -validPoints;
                validPoints ^= p;

                int i = (int) (Math.log(p) / Math.log(2));

                charArray[i] = 'Q';
                solution.add(String.valueOf(charArray));

                backtrack(n + 1, col ^ p, (hill ^ p) << 1, (dale ^ p) >> 1);

                charArray[i] = '.';
                solution.remove(solution.size() - 1);
            }
        }
    }
}
// @lc code=end
