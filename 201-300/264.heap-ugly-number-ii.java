import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class UglyNum {
    private int[] nums = new int[1690];

    public UglyNum() {
        Set<Long> seen = new HashSet<>();
        Queue<Long> min = new PriorityQueue<>();

        seen.add(1l);
        min.add(1l);

        int[] bases = new int[] {2, 3, 5};

        for (int i = 0; i < 1690; i++) {
            long cur = min.poll();
            nums[i] = (int) cur;

            for (int base : bases) {
                long next = cur * base;

                if (!seen.contains(next)) {
                    seen.add(next);
                    min.add(next);
                }
            }
        }
    }

    public int get(int n) {
        return nums[n - 1];
    }
}


class Solution {
    private static UglyNum u = new UglyNum();

    public int nthUglyNumber(int n) {
        return u.get(n);
    }
}
// @lc code=end

