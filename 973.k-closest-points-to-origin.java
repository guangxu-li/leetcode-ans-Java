import java.util.Arrays;

/*
 * @lc app=leetcode id=973 lang=java
 *
 * [973] K Closest Points to Origin
 */

// @lc code=start
class Solution {
    private int[][] points;

    private int quickSelect(int left, int right, int k) {
        while (true) {
            if (left == right) {
                return left;
            }

            int pivot = partition(left, right);

            if (k == pivot) {
                return pivot;
            } else if (k < pivot) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
    }

    private int partition(int left, int right) {
        int pivot = right;
        int i = left;
        for (int j = left; j < right; j++) {
            if (distance(j) < distance(pivot)) {
                swap(i, j);
                i++;
            }
        }

        swap(i, right);

        return i;
    }

    private void swap(int i, int j) {
        int tmp = points[i][0];
        points[i][0] = points[j][0];
        points[j][0] = tmp;

        tmp = points[i][1];
        points[i][1] = points[j][1];
        points[j][1] = tmp;
    }

    private int distance(int i) {
        int x = points[i][0];
        int y = points[i][1];

        return x * x + y * y;
    }

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;

        int k = quickSelect(0, points.length - 1, K - 1);

        return Arrays.copyOfRange(points, 0, k + 1);
    }
}
// @lc code=end

