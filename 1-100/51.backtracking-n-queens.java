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
    private int[] col;
    private int[] posDiag;
    private int[] negDiag;

    private List<String> solution = new ArrayList<>(); /* candidate */
    private List<List<String>> ans = new ArrayList<>(); /* solutions found */

    public List<List<String>> solveNQueens(int n) {
        SIZE = n;
        col = new int[SIZE];
        posDiag = new int[2 * SIZE]; /* 2 * SIZE - 1 groups of diag */
        negDiag = new int[2 * SIZE]; /* in case SIZE = 0 */

        backtrack(n);

        return ans;
    }

    private void backtrack(int n) {
        if (n == 0) {
            ans.add(new ArrayList<>(solution));
        } else {
            char[] charArray = new char[SIZE];
            Arrays.fill(charArray, '.');

            for (int i = 0; i < SIZE; i++) {
                int posIdx = i - n + SIZE;
                int negIdx = i + n - 1;

                if (col[i] + negDiag[negIdx] + posDiag[posIdx] == 0) {
                    col[i] = 1;
                    posDiag[posIdx] = 1;
                    negDiag[negIdx] = 1;

                    charArray[i] = 'Q';

                    solution.add(String.valueOf(charArray));

                    backtrack(n - 1);

                    solution.remove(solution.size() - 1);

                    col[i] = 0;
                    posDiag[posIdx] = 0;
                    negDiag[negIdx] = 0;

                    charArray[i] = '.';
                }
            }
        }
    }
}
// @lc code=end

