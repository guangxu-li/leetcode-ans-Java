import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 */

// @lc code=start
class Solution {
    private Integer[][] cache;

    private int dfs(List<List<Integer>> triangle, int row, int col) {
        if (cache[row][col] != null) {
            return cache[row][col];
        }

        int min = 0;
        if (row != triangle.size()) {
            min = triangle.get(row).get(col)
                    + Math.min(dfs(triangle, row + 1, col), dfs(triangle, row + 1, col + 1));
        }

        cache[row][col] = min;
        return min;
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        cache = new Integer[triangle.size() + 1][triangle.size() + 1];

        return dfs(triangle, 0, 0);
    }
}
// @lc code=end

