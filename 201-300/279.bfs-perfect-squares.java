import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        Set<Integer> vals = new HashSet<>();
        ArrayList<Integer> squares = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            vals.add(i * i);
            squares.add(i * i);
        }

        Set<Integer> q = new HashSet<>();
        q.add(n);

        int level = 0;
        while (!q.isEmpty()) {
            level++;

            Set<Integer> nq = new HashSet<>();
            for (Integer num : q) {
                if (vals.contains(num)) {
                    return level;
                }

                for (int square : squares) {
                    if (num < square) {
                        break;
                    }

                    nq.add(num - square);
                }
            }

            q = nq;
        }

        return level;
    }
}
// @lc code=end

