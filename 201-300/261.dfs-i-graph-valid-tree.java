import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
    private List<List<Integer>> adjs = new ArrayList<>();
    private Set<Integer> visited = new HashSet<>();

    private void dfs(int u) {
        if (visited.contains(u)) {
            return;
        }
        visited.add(u);

        for (int v : adjs.get(u)) {
            dfs(v);
        }
    }

    public boolean validTree(int n, int[][] edges) {

        // there's must be exacly n - 1 edges to make it possible to be a valid tree
        if (edges.length != n - 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            adjs.add(new ArrayList<>());
        }        

        for (int[] edge : edges) {
            adjs.get(edge[0]).add(edge[1]);
            adjs.get(edge[1]).add(edge[0]);
        }

        dfs(0);

        return visited.size() == n;
    }
}
// @lc code=end

