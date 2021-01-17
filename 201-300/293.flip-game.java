import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=293 lang=java
 *
 * [293] Flip Game
 */

// @lc code=start
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        char[] cs = s.toCharArray();
        List<String> states = new ArrayList<>();

        for (int i = 0, j = 1; i < cs.length - 1; i++, j++) {
            if (cs[i] == '+' && cs[j] == '+') {
                cs[i] = '-';
                cs[j] = '-';

                states.add(String.valueOf(cs)); 

                cs[i] = '+';
                cs[j] = '+';
            }
        }

        return states;
    }
}
// @lc code=end

