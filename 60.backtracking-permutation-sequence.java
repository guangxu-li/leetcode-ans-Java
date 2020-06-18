/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
    private char[] ans;

    private int count;
    private int size;
    private boolean flag = false; /* if we have found the k-th sequence */

    public String getPermutation(int n, int k) {
        ans = new char[n];
        count = k;
        size = n;

        char[] candidates = new char[n];
        for (int i = 0; i < size; i++) {
            candidates[i] = (char) ('0' + i + 1);
        }

        backtrack(candidates, 0);

        return String.valueOf(ans);
    }

    private void backtrack(char[] candidates, int pos) {
        if (pos == size) {
            count--;

            if (count == 0) {
                flag = true;
            }
        } else {
            for (int i = 0; i < candidates.length; i++) {
                if (candidates[i] != '.') {
                    ans[pos] = candidates[i];
                    candidates[i] = '.';

                    backtrack(candidates, pos + 1);

                    candidates[i] = ans[pos];
                }

                if (flag) {
                    break;
                }
            }
        }
    }
}
// @lc code=end

