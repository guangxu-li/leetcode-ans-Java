/*
 * @lc app=leetcode id=683 lang=java
 *
 * [683] K Empty Slots
 */

// @lc code=start
class Solution {
    public int kEmptySlots(int[] bulbs, int k) { // O(n) O(n)
        int[] days = new int[bulbs.length];
        for (int i = 0; i < days.length; i++) {
            days[bulbs[i] - 1] = i + 1;
        }

        int lo = 0;
        int hi = k + 1;

        int day = bulbs.length + 1;

        search: while (hi < days.length) {
            int bound = Math.max(days[lo], days[hi]);
            for (int i = lo + 1; i < hi; i++) {
                if (days[i] < bound) {
                    lo = i;
                    hi = i + k + 1;

                    continue search;
                }
            }

            day = Math.min(day, bound);
            lo = hi;
            hi += k + 1;
        }

        return day <= bulbs.length ? day : -1;
    }
}
// @lc code=end

