import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    private void update(int i, int[] bit) {
        while (i < bit.length) {
            bit[i]++; 
            i += i & -i;
        }
    }

    private int sum(int i, int[] bit) {
        int cnt = 0;
        while (i > 0) {
            cnt += bit[i];
            i -= i & -i;
        }

        return cnt;
    }

    public List<Integer> countSmaller(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int shift = -min + 1;
        int[] bit = new int[max - min + 2];

        Integer[] cntSmllr = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            cntSmllr[i] = sum(nums[i] + shift - 1, bit);
            update(nums[i] + shift, bit);
        }

        return Arrays.asList(cntSmllr);
    }
}
// @lc code=end

