import java.util.List;

/*
 * @lc app=leetcode id=1428 lang=java
 *
 * [1428] Leftmost Column with at Least a One
 */

// @lc code=start
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    private int binarySearch(BinaryMatrix bm, int row, int end, int target) {
        if (bm.get(row, end) < target) {
            return end + 1;
        }

        int lo = 0;
        int hi = end;

        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;

            if (bm.get(row, mid) >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) { // O(log(M) + N)
        List<Integer> dimensions = binaryMatrix.dimensions();
        int m = dimensions.get(0);
        int n = dimensions.get(1);

        int end = n;
        for (int i = 0;  i < m; i++) {
            end = binarySearch(binaryMatrix, i, end - 1, 1);
        }

        return end == n ? -1 : end;
    }
}
// @lc code=end

