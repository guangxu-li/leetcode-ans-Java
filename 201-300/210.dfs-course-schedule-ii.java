import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
    private Map<Integer, List<Integer>> courses = new HashMap<>();
    private int[] topo;
    private int idx;

    boolean[] visited;
    boolean[] checked;

    private boolean isCyclic(int head) {
        if (checked[head]) {
            return false;
        }

        if (visited[head]) {
            return true;
        }

        visited[head] = true;

        if (courses.containsKey(head)) {
            for (int next : courses.get(head)) {
                if (isCyclic(next)) {
                    return true;
                }
            }
        }

        visited[head] = false;
        checked[head] = true;

        topo[--idx] = head;

        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        checked = new boolean[numCourses];
        topo = new int[numCourses];
        idx = numCourses;

        for (int[] pre : prerequisites) {
            courses.putIfAbsent(pre[1], new ArrayList<>());
            courses.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i)) {
                return new int[0];
            }
        }

        return topo;
    }
}
// @lc code=end

