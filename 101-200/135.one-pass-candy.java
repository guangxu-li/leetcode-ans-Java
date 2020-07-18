/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) {
            return 0;
        }

        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i != 0 && ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        int sum = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i != ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }

        return sum;
    }
}
// @lc code=end

