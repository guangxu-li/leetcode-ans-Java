import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }

        Set<String> lines = new HashSet<>();
        for (int i = 0; i < points.length; i++) {

            int[] p1 = points[i];

            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];

                Double k = null;
                Double x = 0.0;
                Double y = 0.0;

                if (p1[0] != p2[0]) {
                    k = ((double) (p1[1] - p2[1])) / (p1[0] - p2[0]);
                }

                if (k == null) {
                    x = (double) p1[0];
                } else {
                    y = (double) p1[1] - k * p1[0];
                }

                String K = k == null ? null : String.format("%.8f", k);
                String X = String.format("%.8f", x);
                String Y = String.format("%.8f", y);

                String line = K + " " + X + " " + Y;
                lines.add(line);
            }
        }

        int max = 1;
        double threshold = 0.00001;
        for (String line : lines) {
            String[] elements = line.split(" ");

            Double k = elements[0].equals("null") ? null : Double.parseDouble(elements[0]);
            Double x = Double.parseDouble(elements[1]);
            Double y = Double.parseDouble(elements[2]);

            int count = 0;
            for (int i = 0; i < points.length; i++) {
                int[] p = points[i];

                if ((k == null && p[0] == x)
                        || (k != null && (Math.abs((double) p[1] - k * p[0] - y)) <= threshold)) {
                    count++;
                }
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
// @lc code=end

