import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long) row.get(row.size() - 1) * (rowIndex - i + 1) / i));
        }

        return row;
    }
}
// @lc code=end

