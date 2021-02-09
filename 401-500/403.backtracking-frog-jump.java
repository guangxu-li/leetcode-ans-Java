import java.util.Arrays;

/*
 * @lc app=leetcode id=403 lang=java
 *
 * [403] Frog Jump
 */

// @lc code=start
class Solution {
    private int[] stones;
    private Boolean[][] memo;
    private int n;

    private boolean cross(int pos, int prev) {
        if (memo[pos][prev] != null) {
            return memo[pos][prev];
        }

        boolean canCross = false;
        if (pos == stones.length - 1) {
            canCross = true;
        } else {
            for (int step = prev + 1; step >= Math.max(1, prev - 1); step--) {
                int p = Arrays.binarySearch(stones, pos + 1, n, stones[pos] + step);

                if (p >= 0 && cross(p, step)) {
                    canCross = true;
                    break;
                }
            }
        }

        memo[pos][prev] = canCross;
        return canCross;
    }

    public boolean canCross(int[] stones) {
        this.stones = stones;
        this.n = stones.length;
        this.memo = new Boolean[n][n];

        return cross(0, 0);
    }
}
// @lc code=end

