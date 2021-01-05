import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        for (int lo = 0, hi = 0; hi < nums.length; hi++) {
            if (hi < nums.length - 1 && nums[hi + 1] == nums[hi] + 1) {
                continue;
            }

            if (lo == hi) {
                ranges.add(nums[lo] + "");
            } else {
                ranges.add(nums[lo] + "->" + nums[hi]);
            }

            lo = hi + 1;
        }

        return ranges;
    }
}
// @lc code=end

