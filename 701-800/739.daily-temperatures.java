import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T.length == 0) {
            return T;
        }

        Deque<Integer> temp = new ArrayDeque<>();
        temp.push(0);
        temp.push(T[0]);

        int[] warmer = new int[T.length];

        for (int i = 1; i < T.length; i++) {
            while (!temp.isEmpty() && T[i] > temp.peek()) {
                temp.pop();

                int j = temp.pop();
                warmer[j] = i - j;
            }

            temp.push(i);
            temp.push(T[i]);
        }

        while (!temp.isEmpty()) {
            temp.pop();
            warmer[temp.pop()] = 0;
        }

        return warmer;
    }
}
// @lc code=end

