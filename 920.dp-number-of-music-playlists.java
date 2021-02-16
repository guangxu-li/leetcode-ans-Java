/*
 * @lc app=leetcode id=920 lang=java
 *
 * [920] Number of Music Playlists
 */

// @lc code=start
class Solution {
    private static final int mod = (int) 1e9 + 7;

    public int numMusicPlaylists(int N, int L, int K) { // O(NL) O(N)
        
        /* 
         * dp[l][n] means number of lists whose length is l and number of unique music is n
         * dp[l][n] = dp[l - 1][n - 1] * (N - n + 1) + dp[l - 1][n] * Math.max(n - k, 0);
         */
        long[] dp = new long[N + 1];
        dp[1] = N;

        for (int l = 2; l <= L; l++) {
            long prev = 0;
            for (int n = 1; n <= Math.min(l, N); n++) {
                long tmp = dp[n];
                dp[n] = (dp[n] * Math.max(n - K, 0) + prev * (N - n + 1)) % mod;
                prev = tmp;
            }
        }

        return (int) dp[N];
    }
}
// @lc code=end

