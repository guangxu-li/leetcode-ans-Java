import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=1192 lang=java
 *
 * [1192] Critical Connections in a Network
 */

// @lc code=start
class Solution {
    private int[] distance;
    private int[] origin;
    private int timer = 0;

    private List<List<Integer>> adj = new ArrayList<List<Integer>>();
    private List<List<Integer>> bridges = new ArrayList<List<Integer>>();

    private void dfs(int v, int prev) {
        distance[v] = origin[v] = ++timer;

        for (int u : adj.get(v)) {
            if (u == prev) {
                continue;
            }

            if (distance[u] > 0) {
                origin[v] = Math.min(origin[v], distance[u]);
            } else {
                dfs(u, v);
                origin[v] = Math.min(origin[v], origin[u]);

                if (origin[u] > distance[v]) {
                    bridges.add(Arrays.asList(u, v));
                }
            }
        }
    }

    private void formAdjacency(List<List<Integer>> connections) {
        for (List<Integer> connection : connections) {
            int v = connection.get(0);
            int u = connection.get(1);

            adj.get(v).add(u);
            adj.get(u).add(v);
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        distance = new int[n];
        origin = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        formAdjacency(connections);

        while (--n >= 0) {
            if (distance[n] == 0) {
                dfs(n, 0);
            }
        }

        return bridges;
    }
}
// @lc code=end

