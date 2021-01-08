import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjs.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjs.get(edge[0]).add(edge[1]);
            adjs.get(edge[1]).add(edge[0]);
        }

        Integer[] parents = new Integer[n];
        parents[0] = -1;
        int count = 1;
        Queue<Integer> nodes = new ArrayDeque<>(){{add(0);}};

        while (!nodes.isEmpty()) {
            int node = nodes.poll();

            for (int v : adjs.get(node)) {
                if (parents[node] != null && parents[node] == v) {
                    continue;
                }

                if(parents[v] != null) {
                    return false;
                }

                parents[v] = node;
                count++;
                nodes.add(v);
            }
        }

        return count == n;
    }
}
// @lc code=end

