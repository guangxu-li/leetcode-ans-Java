import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=785 lang=java
 *
 * [785] Is Graph Bipartite?
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] marks = new int[graph.length];
        int mark = 1;
        for (int i = 0; i < graph.length; i++) {
            if (marks[i] != 0) {
                continue;
            }
            marks[i] = mark;

            Queue<Integer> nodes = new LinkedList<>();
            nodes.add(i);
            while (!nodes.isEmpty()) {
                int size = nodes.size();
                while (size-- > 0) {
                    for (int v : graph[nodes.poll()]) {
                        if (marks[v] == mark) {
                            return false;
                        } else if (marks[v] != -mark) {
                            nodes.add(v);
                            marks[v] = -mark;
                        }
                    }
                }

                mark = -mark;
            }
        }

        return true;
    }
}
// @lc code=end

