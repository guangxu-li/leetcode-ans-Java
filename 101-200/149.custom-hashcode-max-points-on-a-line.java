import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Point {
    public long x = 0;
    public long y = 0;

    public Point(int[] p) {
        this.x = p[0];
        this.y = p[1];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }

    @Override
    public int hashCode() {
        return (x + " " + y).hashCode();
    }
}


class Solution {
    public int maxPoints(int[][] points) {
        Map<Point, Integer> ps = new HashMap<>();

        Arrays.stream(points)
                .forEach(p -> ps.put(new Point(p), ps.getOrDefault(new Point(p), 0) + 1));

        Point[] pointArr = new Point[ps.size()];
        int[] counts = new int[pointArr.length];

        int idx = 0;
        for (Map.Entry<Point, Integer> entry : ps.entrySet()) {
            pointArr[idx] = entry.getKey();
            counts[idx] = entry.getValue();

            idx++;
        }

        int max = (pointArr.length == 1) ? counts[0] : 0;

        for (int i = 0; i < pointArr.length; i++) {
            Point p1 = pointArr[i];

            for (int j = i + 1; j < pointArr.length; j++) {
                Point p2 = pointArr[j];

                int count = counts[i] + counts[j];
                for (int k = j + 1; k < pointArr.length; k++) {
                    Point p3 = pointArr[k];
                    count += ((p2.y - p1.y) * (p3.x - p1.x) == (p1.x - p2.x) * (p1.y - p3.y))
                            ? counts[k]
                            : 0;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
// @lc code=end

