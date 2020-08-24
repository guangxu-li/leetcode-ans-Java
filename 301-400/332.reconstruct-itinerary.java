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
    LinkedList<String> itinerary = new LinkedList<>();
    Map<String, Queue<String>> itinerarys = new HashMap<>();

    private void dfs(String cur) {
        if (itinerarys.containsKey(cur)) {
            while (!itinerarys.get(cur).isEmpty()) {
                dfs(itinerarys.get(cur).poll());
            }
        }

        itinerary.addFirst(cur);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (!itinerarys.containsKey(ticket.get(0))) {
                itinerarys.put(ticket.get(0), new PriorityQueue<>());
            }
            itinerarys.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK");

        return itinerary;
    }
}
// @lc code=end

