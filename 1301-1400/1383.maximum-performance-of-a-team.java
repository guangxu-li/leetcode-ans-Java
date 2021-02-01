import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=1383 lang=java
 *
 * [1383] Maximum Performance of a Team
 */

// @lc code=start
class Solution {
    private static final int mod = (int) Math.pow(10, 9) + 7;

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) { // O(n log(n))
        int[][] se = new int[n][];
        for (int i = 0; i < n; i++) {
            se[i] = new int[] {speed[i], efficiency[i]};
        }

        Arrays.sort(se, (a, b) -> b[1] - a[1]);
        Queue<Integer> spds = new PriorityQueue<>();

        long totalSpeed = 0;
        long performance = 0;

        for (int[] arr : se) {
            spds.add(arr[0]);
            totalSpeed += arr[0];

            if (spds.size() > k) {
                totalSpeed -= spds.poll();
            }

            performance = Math.max(performance, totalSpeed * arr[1]); // max before mod operation
        }

        return (int) performance % mod;
    }
}
// @lc code=end

