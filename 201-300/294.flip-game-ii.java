/*
 * @lc app=leetcode id=294 lang=java
 *
 * [294] Flip Game II
 */

// @lc code=start
class Solution {
    private boolean canWin(char[] cs) {
        for (int i = 1; i < cs.length; i++) {
            if (cs[i - 1] == '+' && cs[i] == '+') {
                cs[i - 1] = '-';
                cs[i] = '-';

                boolean win = !canWin(cs);

                // this two lines should run before return result
                cs[i - 1] = '+';
                cs[i] = '+';

                if (win) {
                    return true;
                }

            }
        }
    
        return false;
    }

    public boolean canWin(String s) {
        return canWin(s.toCharArray());
    }
}
// @lc code=end

