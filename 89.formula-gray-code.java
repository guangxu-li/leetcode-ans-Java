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

        // i-th code sequence of the graycode
        for (int i = 0; i < 1 << n; i++) {
            code.add(i ^ (i >> 1));
        }

        return code;
    }
}
// @lc code=end

