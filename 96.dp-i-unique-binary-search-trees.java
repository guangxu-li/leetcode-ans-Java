/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */

// @lc code=start
class Solution {
    private int[][] cache;

    public int numTrees(int n) {
        cache = new int[n + 1][n + 1];
        return numSubtrees(1, n);
    }

    private int numSubtrees(int lo, int hi) {

        if (cache[lo - 1][hi] != 0) {
            return cache[lo - 1][hi];
        }

        int count = 0;
        if (lo > hi) {
            count = 1;
        } else {
            for (int i = lo; i <= hi; i++) {
                int left = numSubtrees(lo, i - 1);
                int right = numSubtrees(i + 1, hi);

                count += left * right;
            }
        }

        cache[lo - 1][hi] = count;
        return count;
    }
}
// @lc code=end

