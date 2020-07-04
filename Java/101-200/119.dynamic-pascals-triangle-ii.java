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
        while (rowIndex-- > 0) {
            int prev = 1;
            for (int i = 1; i < row.size(); i++) {
                int cur = row.get(i);
                row.set(i, prev + cur);
                prev = cur;
            }
            row.add(prev);
        }

        return row;
    }
}
// @lc code=end

