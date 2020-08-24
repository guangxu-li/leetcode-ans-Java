import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=447 lang=java
 *
 * [447] Number of Boomerangs
 */

// @lc code=start
class Solution {
    private int distance(int[][] points, int i, int j) {
        int x = points[i][0] - points[j][0];
        int y = points[i][1] - points[j][1];

        return x * x + y * y;
    }

    public int numberOfBoomerangs(int[][] points) {
        int count = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> distances = new HashMap<>();

            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int dis = distance(points, i, j);
                distances.put(dis, distances.getOrDefault(dis, 0) + 1);
            }

            for (int value : distances.values()) {
                count += value * (value - 1);
            }
        }

        return count;
    }
}
// @lc code=end

