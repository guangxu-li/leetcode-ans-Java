import java.util.Set;
import java.util.TreeSet;

/*
 * @lc app=leetcode id=681 lang=java
 *
 * [681] Next Closest Time
 */

// @lc code=start
class Solution {
    public String nextClosestTime(String time) {
        Set<Integer> digits = new TreeSet<>();
        for (int i = 0; i < time.length(); i++) {
            char c = time.charAt(i);
            if (c != ':') {
                digits.add(c - '0');
            }
        }

        int elapsed = 1440;
        int anchor =
                Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        int next = anchor;

        for (int h1 : digits) {
            if (h1 > 2) {
                break;
            }

            for (int h2 : digits) {
                if (h1 == 2 && h2 > 3) {
                    break;
                }

                int h = h1 * 10 + h2;
                for (int m1 : digits) {
                    if (m1 > 5) {
                        break;
                    }

                    for (int m2 : digits) {
                        int m = m1 * 10 + m2;
                        int t = h * 60 + m;
                        int cur = Math.floorMod(t - anchor, 1440);
                        if (0 < cur && cur < elapsed) {
                            elapsed = cur;
                            next = t;
                        }
                    }
                }
            }
        }

        return String.format("%02d:%02d", next / 60, next % 60);
    }
}
// @lc code=end

