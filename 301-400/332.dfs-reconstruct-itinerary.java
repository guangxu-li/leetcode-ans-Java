import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    private Map<String, List<String>> edges = new HashMap<>();
    private List<String> itinerary = new ArrayList<>();
    private Map<String, Set<Integer>> used = new HashMap<>();

    private boolean reconstruct(List<List<String>> tickets, String cur, int cnt) {
        itinerary.add(cur);
        if (itinerary.size() == tickets.size() + 1) {
            return true;
        }

        List<String> adjs = edges.getOrDefault(cur, new ArrayList<>());
        Set<Integer> visited = used.get(cur);
        for (int i = 0; i < adjs.size(); i++) {
            if (visited.contains(i)) {
                continue;
            }

            visited.add(i);
            String next = adjs.get(i);
            if (reconstruct(tickets, next, cnt + 1)) {
                return true;
            }
            visited.remove(i);
        }
        itinerary.remove(itinerary.size() - 1);

        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(0).equals(b.get(0)) ? a.get(1).compareTo(b.get(1))
                : a.get(0).compareTo(b.get(0)));

        for (List<String> ticket : tickets) {
            edges.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
            used.put(ticket.get(0), new HashSet<>());
        } 

        reconstruct(tickets, "JFK", 0);

        return itinerary;
    }
}
// @lc code=end

