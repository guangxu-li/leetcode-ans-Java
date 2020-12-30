import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courses = new HashMap<>();
        int[] ingress = new int[numCourses];

        // establish adjacency map
        for (int[] prerequisite : prerequisites) {
            courses.putIfAbsent(prerequisite[1], new ArrayList<>());
            courses.get(prerequisite[1]).add(prerequisite[0]);

            ingress[prerequisite[0]]++;
        }

        // put in head (ingress == 0)
        Queue<Integer> heads = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (ingress[i] == 0) {
                heads.add(i);
            }
        }

        int[] topo = new int[numCourses];
        int idx = 0;
        int edges = prerequisites.length;

        // Kahn's algorithm
        while (!heads.isEmpty()) {
            int head = heads.poll();
            topo[idx++] = head;

            if (!courses.containsKey(head)) {
                continue;
            }

            for (int next : courses.get(head)) {
                edges--;

                if (--ingress[next] == 0) {
                    heads.add(next);
                }
            }
        }

        return edges == 0 ? topo : new int[0];
    }
}
// @lc code=end

