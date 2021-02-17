import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 */

// @lc code=start
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> skyline = new ArrayList<>();
        List<int[]> points = new ArrayList<>();

        for (int[] building : buildings) {
            points.add(new int[] {building[0], -building[2]});
            points.add(new int[] {building[1], building[2]});
        }

        Collections.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> heights = new TreeMap<>();
        heights.put(0, 1);

        int max = 0;
        for (int[] point : points) {
            if (point[1] < 0) {
                heights.put(-point[1], heights.getOrDefault(-point[1], 0) + 1);
            } else {
                if(heights.put(point[1], heights.get(point[1]) - 1) == 1) {
                    heights.remove(point[1]);
                }
            }

            int last = heights.lastKey();
            if (last != max) {
                max = last;
                skyline.add(Arrays.asList(point[0], max));    
            }
        }

        return skyline;

    }
}
// @lc code=end

