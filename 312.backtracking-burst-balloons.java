/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
    private Integer[][] cache;

    private int dfs(int[] ns, int left, int right) {
        if (cache[left][right] != null) {
            return cache[left][right];
        }

        int max = 0;
        if (left + 1 < right) {
            for (int i = left + 1; i < right; i++) {
                max = Math.max(max,
                        ns[left] * ns[i] * ns[right] + dfs(ns, left, i) + dfs(ns, i, right));
            }
        }

        cache[left][right] = max;
        return max;
    }

    public int maxCoins(int[] nums) {
        int[] ns = new int[nums.length + 2];
        ns[0] = 1;
        ns[ns.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            ns[i + 1] = nums[i];
        }

        this.cache = new Integer[ns.length][ns.length];

        return dfs(ns, 0, ns.length - 1);
    }
}
// @lc code=end

