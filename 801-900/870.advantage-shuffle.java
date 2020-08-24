import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=870 lang=java
 *
 * [870] Advantage Shuffle
 */

// @lc code=start
class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int[] C = new int[A.length];

        Queue<int[]> BMax = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < B.length; i++) {
            BMax.add(new int[] {i, B[i]});
        }

        int lo = 0;
        int hi = A.length - 1;

        while (!BMax.isEmpty()) {
            int[] max = BMax.poll();

            C[max[0]] = max[1] >= A[hi] ? A[lo++] : A[hi--];
        }

        return C;
    }
}
// @lc code=end


