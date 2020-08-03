import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> vals = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            vals.add(num);
        }

        int num = 0;
        while (k-- > 0) {
            num = vals.poll();
        }

        return num;
    }
}
// @lc code=end

