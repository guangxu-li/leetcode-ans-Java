import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=1152 lang=java
 *
 * [1152] Analyze User Website Visit Pattern
 */

// @lc code=start
class WebsiteVisit {
    public String username;
    public int timestamp;
    public String website;

    public WebsiteVisit(String username, int timestamp, String website) {
        this.username = username;
        this.timestamp = timestamp;
        this.website = website;
    }
}


class Solution {
    private List<WebsiteVisit> logs = new ArrayList<>();
    private Map<List<String>, Integer> counter = new HashMap<>();

    private void getPermutationCounter(int lo, int hi) {
        Set<List<String>> set = new HashSet<>();

        for (int i = lo; i <= hi - 2; i++) {
            for (int j = i + 1; j <= hi - 1; j++) {
                for (int k = j + 1; k <= hi; k++) {
                    List<String> l = new ArrayList<>();
                    l.add(logs.get(i).website);
                    l.add(logs.get(j).website);
                    l.add(logs.get(k).website);

                    set.add(l);
                }
            }
        }

        set.forEach(l -> counter.put(l, counter.getOrDefault(l, 0) + 1));
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        for (int i = 0; i < username.length; i++) {
            logs.add(new WebsiteVisit(username[i], timestamp[i], website[i]));
        }
        logs.sort((a, b) -> a.username.equals(b.username) ? a.timestamp - b.timestamp
                : a.username.compareTo(b.username));

        int anchor = 0;
        for (int i = 0; i < logs.size(); i++) {
            if (i == logs.size() - 1 || !logs.get(i).username.equals(logs.get(i + 1).username)) {
                getPermutationCounter(anchor, i);
                anchor = i + 1;
            }
        }

        return Collections.max(counter.entrySet(),
                (a, b) -> a.getValue() == b.getValue()
                        ? b.getKey().toString().compareTo(a.getKey().toString())
                        : a.getValue() - b.getValue())
                .getKey();
    }
}
// @lc code=end

