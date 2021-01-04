import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> visited = new HashSet<>();

        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            }

            visited.add(num);
        }

        return false;
    }
}
// @lc code=end

