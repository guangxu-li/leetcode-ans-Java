/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    private int getNext(int n) {
        int next = 0;
        while (n > 0) {
            int rem = n % 10;
            next += rem * rem;
            n /= 10;
        }

        return next;
    }

    public boolean isHappy(int n) {
        int tortoise = n;
        int hare = getNext(n);

        while (hare != 1 && tortoise != hare) {
            tortoise = getNext(tortoise);
            hare = getNext(getNext(hare));
        }

        return hare == 1;
    }
}
// @lc code=end

