import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {

    public int[][] kClosest(int[][] points, int K) {
        Comparator<int[]> cmp = new Comparator<int[]>() {
            @Override
            public int compare(int[] x, int[] y) {
                return (x[0] * x[0] + x[1] * x[1]) - (y[0] * y[0] + y[1] * y[1]);
            }
        };

        Arrays.sort(points, cmp);

        return Arrays.copyOfRange(points, 0, K);
    }
}
// @lc code=end

