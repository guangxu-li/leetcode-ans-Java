/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class UglyNum {
    private int[] nums = new int[1690];

    public UglyNum() {
        nums[0] = 1;

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        for (int i = 1; i < 1690; i++) {
            int v1 = nums[p1] * 2;
            int v2 = nums[p2] * 3;
            int v3 = nums[p3] * 5;

            int min = Math.min(v1, Math.min(v2, v3));
            nums[i] = min;

            if (min == v1) {
                p1++;
            }

            if (min == v2) {
                p2++;
            }

            if (min == v3) {
                p3++;
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

