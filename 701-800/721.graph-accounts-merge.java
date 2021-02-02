import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=721 lang=java
 *
 * [721] Accounts Merge
 */

// @lc code=start
class Solution {
    private void dfs(Map<String, List<String>> graph, Set<String> visited, List<String> account, String key) {
        if (visited.contains(key)) {
            return;
        }
        account.add(key);
        visited.add(key);

        for (String v : graph.get(key)) {
            dfs(graph, visited, account, v);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> e2name = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                String anchor = account.get(1);
                graph.computeIfAbsent(email, k -> new ArrayList<>()).add(anchor);
                graph.computeIfAbsent(anchor, k -> new ArrayList<>()).add(email);

                e2name.put(email, name);
            }
        }

        List<List<String>> output = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for (String key : graph.keySet()) {
            if (visited.contains(key)) {
                continue;
            }

            List<String> account = new ArrayList<>();
            dfs(graph, visited, account, key);
            output.add(account);
        }

        for (List<String> account : output) {
            Collections.sort(account);
            account.add(0, e2name.get(account.get(0)));
        }

        return output;
    }
}
// @lc code=end

