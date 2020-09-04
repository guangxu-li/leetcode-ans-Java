/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String max = Arrays.stream(nums).mapToObj(Integer::toString)
                .sorted((a, b) -> (b + a).compareTo(a + b)).collect(Collectors.joining());

        return max.charAt(0) == '0' ? "0" : max;
    }
}
// @lc code=end

