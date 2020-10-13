import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class MinStack {
    private Deque<int[]> nums;

    /** initialize your data structure here. */
    public MinStack() {
        nums = new ArrayDeque<>();
    }

    public void push(int x) {
        int curMin = nums.size() == 0 ? x : nums.peek()[1];

        nums.push(new int[] {x, Math.min(x, curMin)});
    }

    public void pop() {
        nums.pop();
    }

    public int top() {
        return nums.peek()[0];
    }

    public int getMin() {
        return nums.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

