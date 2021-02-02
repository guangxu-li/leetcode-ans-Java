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
class UnionFind {
    private int[] parents;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int i) {
        return i == parents[i] ? i : find(parents[i]);
    }

    public void union(int a, int b) {
        parents[find(a)] = find(b);
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        Map<String, Integer> e2id = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (e2id.containsKey(email)) {
                    uf.union(i, e2id.get(email));
                } else {
                    e2id.put(email, i);
                }
            }
        }

        Map<Integer, Set<String>> accnts = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int root = uf.find(i);
            List<String> account = accounts.get(i);
            account = account.subList(1, account.size());

            accnts.computeIfAbsent(root, k -> new HashSet<>()).addAll(account);
        }

        List<List<String>> output = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : accnts.entrySet()) {
            int key = entry.getKey();
            List<String> value = new ArrayList<>(entry.getValue());
            Collections.sort(value);
            value.add(0, accounts.get(key).get(0));

            output.add(value);
        }

        return output;
    }
}
// @lc code=end

