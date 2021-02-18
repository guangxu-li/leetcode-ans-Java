import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
    private int binarySearch(List<Integer> vals, int target) {
        int lo = 0;
        int hi = vals.size() - 1;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (vals.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        vals.add(lo, target);
        return lo;
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] cntSmaller = new Integer[n];        
        List<Integer> vals = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            cntSmaller[i] = binarySearch(vals, nums[i]);
        }

        return Arrays.asList(cntSmaller);
    }
}
// @lc code=end

