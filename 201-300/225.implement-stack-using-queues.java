import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
class MyStack {
    private Queue<Integer> queue;
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>(); 
        top = 0;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int head = queue.peek();
        while (queue.peek() != top) {
            head = queue.peek();
            queue.add(queue.poll());
        }

        top = head;
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end


