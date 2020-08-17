import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=1086 lang=java
 *
 * [1086] High Five
 */

// @lc code=start
class Solution {
    public int[][] highFive(int[][] items) {
        Comparator<int[]> cmp = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        };

        Arrays.sort(items, cmp);

        int numOfId = 0;
        int prev = 0;
        for (int[] item : items) {
            if (item[0] != prev) {
                prev = item[0];
                numOfId++;
            }
        }

        int[][] scores = new int[numOfId][2];
        int index = 0;
        prev = 0;

        int i = 0;
        while (i < items.length) {
            int id = items[i][0];
            if (prev == id) {
                i++;
                continue;
            }
            prev = id;

            int sum = 0;
            int n = 5;
            while (n-- > 0) {
                sum += items[i++][1];
            }
            scores[index++] = new int[] {id, sum / 5};
        }

        return scores;
    }
}
// @lc code=end

