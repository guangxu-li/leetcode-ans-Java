import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
    private Map<String, ArrayList<String>> itinerarys = new HashMap<>();
    private List<String> itinerary = new ArrayList<>();
    private int size;

    private void dfs(String cur) {
        if (!itinerarys.containsKey(cur) || itinerarys.get(cur).size() == 0) {
            return;
        } else {
            List<String> strings = itinerarys.get(cur);
            for (int i = 0; i < strings.size(); i++) {
                String string = strings.get(i);
                if (string == null) {
                    continue;
                }

                itinerary.add(string);
                strings.set(i, null);

                dfs(string);

                if (itinerary.size() != size) {
                    itinerary.remove(itinerary.size() - 1);
                    strings.set(i, string);
                }
            }
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (!itinerarys.containsKey(ticket.get(0))) {
                itinerarys.put(ticket.get(0), new ArrayList<>());
            }
            itinerarys.get(ticket.get(0)).add(ticket.get(1));
        }

        for (List<String> itinerary : itinerarys.values()) {
            Collections.sort(itinerary);
        }

        String cur = "JFK";
        itinerary.add(cur);
        size = tickets.size() + 1;
        dfs(cur);

        return itinerary;
    }
}
// @lc code=end

