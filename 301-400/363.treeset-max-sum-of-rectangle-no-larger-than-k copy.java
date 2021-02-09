import java.util.TreeSet;

/*
 * @lc app=leetcode id=363 lang=java
 *
 * [363] Max Sum of Rectangle No Larger Than K
 */

// @lc code=start
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = Math.max(matrix.length, matrix[0].length);
        int n = Math.min(matrix.length, matrix[0].length);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sums[] = new int[m];

            for (int j = i; j < n; j++) {
                TreeSet<Integer> areas = new TreeSet<>();
                int area = 0;

                for (int l = 0; l < m; l++) {
                    sums[l] += matrix.length > matrix[0].length ? matrix[l][j] : matrix[j][l];
                    area += sums[l];
                    if (area == k) {
                        return k;
                    } else if (area < k) {
                        max = Math.max(max, area);
                    }
                    
                    /* cur -> from 0 to l, try to find the largest from x to l, whose area smller
                     * than k.
                     * 
                     * area of (x, l) = area of (0, l) - area of (0, x - 1)
                     * let it be x = area - loss
                     * we want x <= k, then loss = area - x >= area - k
                     * meanwhile x should be as largest as possible, which means loss should be as
                     * small as possible
                     * 
                     * -> ceiling(area - k)*/
                    Integer loss = areas.ceiling(area - k);
                    if (loss != null) {
                        max = Math.max(max, area - loss);
                    }

                    areas.add(area);
                }
            }
        }

        return max;
    }
}
// @lc code=end

