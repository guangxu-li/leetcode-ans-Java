/*
 * @lc app=leetcode id=1220 lang=java
 *
 * [1220] Count Vowels Permutation
 */

// @lc code=start
class Solution {
    private int[][] vowels =
            new int[][] {{1}, {0, 2}, {0, 1, 3, 4}, {2, 4}, {0}, {0, 1, 2, 3, 4}};
    private int[][] memo;
    private static final int mod = (int) 1e9 + 7;

    private int permutation(int pos, int n, int prev) {
        if (memo[pos][prev] > 0) {
            return memo[pos][prev];
        }

        int cnt = 0;
        if (pos == n) {
            cnt = 1;
        } else {
            for (int vowel : vowels[prev]) {
                cnt = (cnt + permutation(pos + 1, n, vowel)) % mod;
            }
        }

        memo[pos][prev] = cnt;
        return cnt;
    }

    // 1 <= n <= 2 * 10 ^ 4
    public int countVowelPermutation(int n) {
        this.memo = new int[n + 1][6];

        return (int) permutation(0, n, 5);
    }
}
// @lc code=end


