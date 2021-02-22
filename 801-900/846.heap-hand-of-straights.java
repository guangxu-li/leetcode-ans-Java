import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=846 lang=java
 *
 * [846] Hand of Straights
 */

// @lc code=start
class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if (n % W > 0) {
            return false;
        }

        List<Queue<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < W; i++) {
            buckets.add(new PriorityQueue<>());
        }
        
        int group = n / W;
        for (int card : hand) {
            int i = card % W;
            Queue<Integer> bucket = buckets.get(i);
            if (bucket.size() == group) {
                return false;
            }

            bucket.add(card);
        }

        while (group-- > 0) {
            Queue<Integer> cards = new PriorityQueue<>();
            for (Queue<Integer> bucket : buckets) {
                cards.add(bucket.poll());
            }

            int prev = cards.poll();
            while (!cards.isEmpty()) {
                int cur = cards.poll();
                if (prev + 1 < cur) {
                    return false;
                }
                prev = cur;
            }
        }

        return true;
    }
}
// @lc code=end

