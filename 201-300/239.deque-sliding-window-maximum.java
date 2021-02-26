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
        Deque<Integer> indices = new ArrayDeque<>();
        int[] maxNums = new int[nums.length - k + 1];
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!indices.isEmpty() && indices.peekLast() == i - k) {
                indices.pollLast();
            }

            while (!indices.isEmpty() && nums[indices.peek()] < nums[i]) {
                indices.pop();
            }

            indices.push(i);
            if (i >= k - 1) {
                maxNums[idx++] = nums[indices.peekLast()];
            }
        }

        return maxNums;
    }
}
// @lc code=end

