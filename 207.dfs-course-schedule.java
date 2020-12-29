import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    private Map<Integer, List<Integer>> courses = new HashMap<>();
    private boolean[] checked;
    private boolean[] visited;

    private boolean isCyclic(int i) {
        if (checked[i] || !courses.containsKey(i)) {
            return false;
        }

        if (visited[i]) {
            return true;
        }

        visited[i] = true;
        for (int next : courses.get(i)) {
            if (isCyclic(next)) {
                return true;
            }
        }

        visited[i] = false;
        checked[i] = true;

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            courses.putIfAbsent(pre[1], new ArrayList<>());
            courses.get(pre[1]).add(pre[0]);
        }

        this.checked = new boolean[numCourses];
        this.visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCyclic(i)) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

