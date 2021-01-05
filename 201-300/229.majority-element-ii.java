import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {

        // At most 2 elements could appears more than nums.length / 3 times in the array
        int count1 = 0;
        int count2 = 0;

        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            } else if (candidate2 != null && candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        List<Integer> majorities = new ArrayList<>();

        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (candidate1 != null && candidate1 == num) {
                count1++;
            }

            if (candidate2 != null && candidate2 == num) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            majorities.add(candidate1);
        }

        if (count2 > nums.length / 3) {
            majorities.add(candidate2);
        }

        return majorities;
    }
}
// @lc code=end

