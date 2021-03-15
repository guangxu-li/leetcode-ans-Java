import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=962 lang=java
 *
 * [962] Maximum Width Ramp
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] A) {
        Queue<int[]> nums = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        for (int i = 0; i < A.length; i++) {
            nums.add(new int[] {A[i], i});
        }

        int max = 0;
        int p = 0;
        boolean[] visited = new boolean[A.length];
        while (!nums.isEmpty()) {
            while (visited[p]) {
                p++;
            }

            int candidate = nums.poll()[1];
            max = Math.max(max, candidate - p);
            visited[candidate] = true;
        }

        return max;
    }
}
// @lc code=end

