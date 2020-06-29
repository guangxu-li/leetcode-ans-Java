import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=1431 lang=java
 *
 * [1431] Kids With the Greatest Number of Candies
 */

// @lc code=start
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>();
        int target = Arrays.stream(candies).max().getAsInt() - extraCandies;

        for (int candie : candies) {
            res.add(candie >= target);
        }

        return res;
    }
}
// @lc code=end

