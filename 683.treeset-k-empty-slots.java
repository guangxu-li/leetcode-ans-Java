import java.util.TreeSet;

/*
 * @lc app=leetcode id=683 lang=java
 *
 * [683] K Empty Slots
 */

// @lc code=start
class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> on = new TreeSet<>();
        for (int i = 0; i < bulbs.length; i++) {
            int day = i + 1;
            int pos = bulbs[i];
            on.add(pos);
            Integer lo = on.lower(pos);
            Integer hi = on.higher(pos);

            if (lo != null && pos - lo == k + 1 || (hi != null && hi - pos == k + 1)) {
                return day;
            }
        }

        return -1;
    }
}
// @lc code=end

