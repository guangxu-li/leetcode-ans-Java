import java.util.Stack;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int prev = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int dis = i - stack.peek() - 1;
                ans += dis * (Math.min(height[stack.peek()], height[i]) - height[prev]);
            }

            stack.push(i);
        }

        return ans;
    }
}
// @lc code=end
