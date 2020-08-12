import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }

        Deque<Integer> indices = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        int[] maxNums = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (!indices.isEmpty() && indices.peekFirst() == i - k) {
                indices.pollFirst();
            }

            while (!indices.isEmpty() && nums[indices.peekLast()] < nums[i]) {
                indices.pollLast();
            }

            indices.add(i);

            if (i < k) {
                max = Math.max(max, nums[i]);
            } else {
                maxNums[i - k + 1] = nums[indices.peekFirst()];
            }
        }

        maxNums[0] = max;
        return maxNums;
    }
}
// @lc code=end

