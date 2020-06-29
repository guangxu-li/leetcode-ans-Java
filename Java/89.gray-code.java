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

        int prev = 0;
        for (int i = 0; i < 1 << n; i++) {
            prev ^= (i & 1) == 1 ? 1 : (prev & -prev) << 1;
            code.add(prev);
        }

        return code;
    }
}
// @lc code=end

