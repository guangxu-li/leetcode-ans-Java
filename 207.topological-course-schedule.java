import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courses = new HashMap<>();
        int[] ingress = new int[numCourses];

        for (int[] pre : prerequisites) {
            courses.putIfAbsent(pre[1], new ArrayList<>());
            courses.get(pre[1]).add(pre[0]);
            ingress[pre[0]]++;
        }

        Queue<Integer> heads = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (ingress[i] == 0) {
                heads.add(i);
            }
        }

        int edges = prerequisites.length;
        while (!heads.isEmpty()) {
            int head = heads.poll();

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

        return edges == 0;
    }
}
// @lc code=end

