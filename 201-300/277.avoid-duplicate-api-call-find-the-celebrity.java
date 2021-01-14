/*
 * @lc app=leetcode id=277 lang=java
 *
 * [277] Find the Celebrity
 */

// @lc code=start
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                prev = candidate;
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == candidate) {
                continue;
            }

            if (i != prev && !knows(i, candidate)) {
                return -1;
            }

            if (i < candidate && knows(candidate, i)) {
                return -1;
            }
        }

        return candidate;
    }
}
// @lc code=end

