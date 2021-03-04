import java.util.Arrays;

/*
 * @lc app=leetcode id=575 lang=java
 *
 * [575] Distribute Candies
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        return Math.min(candyType.length / 2, (int) Arrays.stream(candyType).distinct().count());
    }
}
// @lc code=end

