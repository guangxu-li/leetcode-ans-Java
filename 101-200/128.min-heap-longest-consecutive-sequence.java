import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
        }

        int maxCount = 1;
        int count = 1;
        int prev = priorityQueue.poll();
        while (!priorityQueue.isEmpty()) {
            int cur = priorityQueue.poll();

            if (prev + 1 == cur) {
                count++;
            } else if (prev != cur) {
                count = 1;
            }

            prev = cur;
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
// @lc code=end

