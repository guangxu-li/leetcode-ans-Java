import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=1296 lang=java
 *
 * [1296] Divide Array in Sets of K Consecutive Numbers
 */

// @lc code=start
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) { // O(n log(n))
        int n = nums.length;
        if (n % k > 0) {
            return false;
        }
        List<Queue<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new PriorityQueue<>());
        }
        
        int group = n / k;
        for (int num : nums) {
            int i = num % k;
            Queue<Integer> bucket = buckets.get(i);
            if (bucket.size() == group) {
                return false;
            }
            bucket.add(num);
        }
        
        while (group-- > 0) {
            Queue<Integer> pair = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                pair.add(buckets.get(i).poll());
            }

            int prev = pair.poll();
            while (!pair.isEmpty()) {
                int cur = pair.poll();
                if (prev + 1 != cur) {
                    return false;
                }
                prev = cur;
            }
        }

        return true;
    }
}
// @lc code=end

