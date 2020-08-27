import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int a = 0;
        int b = 0;

        List<int[]> intervals = new ArrayList<>();
        while (a < A.length && b < B.length) {
            int lo = Math.max(A[a][0], B[b][0]);
            int hi = Math.min(A[a][1], B[b][1]);

            if (lo <= hi) {
                intervals.add(new int[] {lo, hi});
            }

            if (A[a][1] < B[b][1]) {
                a++;
            } else {
                b++;
            }
        }

        return intervals.toArray(new int[intervals.size()][2]);
    }
}
// @lc code=end

