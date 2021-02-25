/*
 * @lc app=leetcode id=992 lang=java
 *
 * [992] Subarrays with K Different Integers
 */

// @lc code=start
class Solution {
    private int subArrayWithAtMostKDistinct(int[] A, int K) {
        int[] found = new int[20001];
        int lo = 0;
        int hi = 0;

        int cnt = 0;
        int ans = 0;

        while (hi < A.length) {
            if (cnt == K && found[A[hi]] == 0) {
                if (--found[A[lo++]] == 0) {
                    cnt--;
                }
            } else {
                if (found[A[hi++]]++ == 0) {
                    cnt++;
                }

                ans += hi - lo;
            }
        }

        return ans;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return subArrayWithAtMostKDistinct(A, K) - subArrayWithAtMostKDistinct(A, K - 1);
    }
}
// @lc code=end

