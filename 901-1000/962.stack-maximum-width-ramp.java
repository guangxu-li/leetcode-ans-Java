import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=962 lang=java
 *
 * [962] Maximum Width Ramp
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] A) {
        Deque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            if (nums.isEmpty() || A[nums.peek()] > A[i]) {
                nums.push(i);
            }
        }

        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            while (!nums.isEmpty() && A[i] >= A[nums.peek()]) {
                max = Math.max(max, i - nums.pop());
            }
        }

        return max;
    }
}
// @lc code=end

