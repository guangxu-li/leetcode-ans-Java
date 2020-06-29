import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 */

// @lc code=start
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<>();
        code.add(0);

        for (int mask = 0; mask < n; mask++) {
            for (int prev = code.size() - 1; prev >= 0; prev--) {
                code.add((1 << mask) | code.get(prev));
            }
        }

        return code;
    }
}
// @lc code=end

