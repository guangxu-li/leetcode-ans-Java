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
        count = k;
        size = n;

        ans = new char[n];
        for (int i = 0; i < size; i++) {
            ans[i] = (char) ('0' + i + 1);
        }


        backtrack(0);

        return String.valueOf(ans);
    }

    private void backtrack(int pos) {
        if (pos == size) {
            count--;

            if (count == 0) {
                flag = true;
            }
        } else {
            if (pos != size - 1 && ans[pos] > ans[pos + 1]) {
                swap(ans, pos, pos + 1);
            }

            for (int i = pos; i < size; i++) {
                swap(ans, pos, i);

                backtrack(pos + 1);

                if (flag) {
                    break;
                }

                swap(ans, pos, i);
            }
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}
// @lc code=end

