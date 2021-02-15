/*
 * @lc app=leetcode id=1220 lang=java
 *
 * [1220] Count Vowels Permutation
 */

// @lc code=start
class Solution {
    private static final int mod = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        long a = 1, e = 1, i = 1, o = 1, u = 1;

        for (int j = 2; j <= n; j++) {
            long na = (e + i + u) % mod;
            long ne = (a + i) % mod;
            long ni = (e + o) % mod;
            long no = i % mod;
            long nu = (i + o) % mod;

            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }

        return (int) (a + e + i + o + u) % mod;
    }
}
// @lc code=end

