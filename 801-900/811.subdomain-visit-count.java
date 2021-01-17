import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=811 lang=java
 *
 * [811] Subdomain Visit Count
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();

        for (String domain : cpdomains) {
            String[] pattern = domain.split(" |\\.");
            int n = pattern.length;
            int cnt = Integer.parseInt(pattern[0]);

            String base = "";
            for (int i = n - 1; i >= 1; i--) {
                base = pattern[i] + (i == n - 1 ? "" : ".") + base;
                counts.put(base, counts.getOrDefault(base.toString(), 0) + cnt);
            }
        }

        List<String> visits = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            visits.add(String.valueOf(entry.getValue()) + " " +entry.getKey());
        }

        return visits;
    }
}
// @lc code=end

