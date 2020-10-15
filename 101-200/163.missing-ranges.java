import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=163 lang=java
 *
 * [163] Missing Ranges
 */

// @lc code=start
class Solution {
    private String range(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } else {
            return lower + "->" + upper;
        }
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missing = new ArrayList<>();

        for (int i = 0; i < nums.length && lower <= upper; i++) {
            if (nums[i] >= lower && nums[i] <= upper) {
                if (nums[i] > lower) {
                    missing.add(range(lower, nums[i] - 1));
                }

                lower = nums[i] + 1;
            }
        }

        if (lower <= upper) {
            missing.add(range(lower, upper));
        }

        return missing;
    }
}
// @lc code=end

