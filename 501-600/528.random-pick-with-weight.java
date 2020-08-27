import java.util.Random;

/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    private int[] w;
    private Random rand;
    private int[] sum;

    public Solution(int[] w) {
        this.w = w;
        this.rand = new Random();
        this.sum = new int[w.length];

        int i = 0;
        for (int num : w) {
            sum[i] = i == 0 ? num : num + sum[i - 1];
            i++;
        }
    }

    public int pickIndex() {
        int r = rand.nextInt(sum[w.length - 1]) + 1;

        int lo = 0;
        int hi = sum.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            if (sum[mid] < r) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

