/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
    private int days(int[] piles, int cnt) {
        int days = 0;
        for (int pile : piles) {
            days += (pile - 1) / cnt + 1;
        }

        return days;
    }

    public int minEatingSpeed(int[] piles, int H) {
        int sum = 0;
        int hi = 0;
        for (int pile : piles) {
            hi = Math.max(hi, pile);
            sum += pile;
        }   
        int lo = (sum - 1) / H + 1; // ceil

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (days(piles, mid) <= H) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
// @lc code=end


