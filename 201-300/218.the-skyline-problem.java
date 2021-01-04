import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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

        for (int i = 0; i < buildings.length; i++) {
            points.add(new int[]{buildings[i][0], -buildings[i][2], i});
            points.add(new int[]{buildings[i][1], buildings[i][2], i});
        }

        Collections.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        Queue<int[]> heights = new PriorityQueue<>((a, b) -> b[0] - a[0]){{add(new int[] {0, Integer.MAX_VALUE});}};

        int prev = 0;
        for (int[] point : points) {
            if (point[1] < 0) {
                heights.add(new int[] {-point[1], buildings[point[2]][1]});
            } else {
                while(heights.size() > 1 && heights.peek()[1] <= buildings[point[2]][1]) {
                    heights.poll();
                }
            }

            if (prev != heights.peek()[0]) {
                skyline.add(new ArrayList<>(){{add(point[0]); add(heights.peek()[0]);}});
                prev = heights.peek()[0];
            }
        }

        return skyline;
    }
}
// @lc code=end

