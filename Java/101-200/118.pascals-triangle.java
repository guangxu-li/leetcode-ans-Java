import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();

        if (numRows == 0) {
            return rows;
        }

        rows.add(new ArrayList<>());
        rows.get(0).add(1);
        while (--numRows > 0) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = rows.get(rows.size() - 1);
            for (int i = 0; i <= prevRow.size(); i++) {
                if (i == 0 || i == prevRow.size()) {
                    row.add(1);
                } else {
                    row.add(prevRow.get(i - 1) + prevRow.get(i));
                }
            }

            rows.add(row);
        }

        return rows;
    }
}
// @lc code=end

