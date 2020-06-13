import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    private Map<int[], List<int[]>> graph = new HashMap<>();
    private List<List<int[]>> components = new ArrayList<>();
    private Set<int[]> visited = new HashSet<>();

    private int componentNumber = 0;

    public int[][] merge(int[][] intervals) {
        buildComponents(intervals);

        List<int[]> merged = new ArrayList<>();

        for (List<int[]> component : components) {
            merged.add(mergeComponent(component));
        }

        return merged.toArray(new int[components.size()][]);
    }

    private void buildComponents(int[][] intervals) {
        buildGraph(intervals);

        for (int[] interval : intervals) {
            if (!visited.contains(interval)) {
                dfs(interval);
                componentNumber++;
            }
        }
    }

    private void buildGraph(int[][] intervals) {

        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            graph.put(currInterval, new ArrayList<>());

            for (int j = 0; j < intervals.length; j++) {
                int[] nextInterval = intervals[j];

                if (overlap(currInterval, nextInterval) && currInterval != nextInterval) {
                    graph.get(currInterval).add(nextInterval);
                }
            }
        }
    }

    private void dfs(int[] interval) {
        Stack<int[]> stack = new Stack<>();

        stack.add(interval);

        while (!stack.isEmpty()) {
            int[] node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);

                if (components.size() == componentNumber) {
                    components.add(new ArrayList<>());
                }

                components.get(componentNumber).add(node);

                for (int[] child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }

    private boolean overlap(int[] currInterval, int[] nextInterval) {
        return currInterval[0] <= nextInterval[1] && currInterval[1] >= nextInterval[0];
    }

    private int[] mergeComponent(List<int[]> intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }

        return new int[] {min, max};
    }
}
// @lc code=end

