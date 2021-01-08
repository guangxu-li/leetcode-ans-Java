import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adjs = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) {
                    add(new ArrayList<>());
                }
            }
        };

        for (int[] edge : edges) {
            adjs.get(edge[0]).add(edge[1]);
            adjs.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> nodes = new ArrayDeque<>();
        nodes.add(0);
        Set<Integer> visited = new HashSet<>();

        while (!nodes.isEmpty()) {
            int node = nodes.poll();

            if (visited.contains(node)) {
                continue;
            }
            visited.add(node);

            for (int v : adjs.get(node)) {
                nodes.add(v);
            }
        }

        return visited.size() == n;
    }
}
// @lc code=end

