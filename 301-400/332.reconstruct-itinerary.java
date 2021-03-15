import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    Map<String, Queue<String>> edges = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    private void reconstruct(String cur) {
        Queue<String> adjs = edges.getOrDefault(cur, new PriorityQueue<>());
        while (!adjs.isEmpty()) {
            reconstruct(adjs.poll());
        }

        itinerary.addFirst(cur);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            edges.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        reconstruct("JFK");

        return itinerary;
    }
}
// @lc code=end

