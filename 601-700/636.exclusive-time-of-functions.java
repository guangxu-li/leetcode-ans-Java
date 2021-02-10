import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=636 lang=java
 *
 * [636] Exclusive Time of Functions
 */

// @lc code=start
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTime = new int[n];
        int time = 0;
        Deque<Integer> funcs = new ArrayDeque<>();

        for (String log : logs) {
            String[] parse = log.split(":");
            int id = Integer.parseInt(parse[0]);
            String status = parse[1];
            int slot = Integer.parseInt(parse[2]);

            if (status.equals("start")) {
                if (!funcs.isEmpty()) {
                    exclusiveTime[funcs.peek()] += slot - time;
                }

                funcs.push(id);
            } else {
                exclusiveTime[funcs.pop()] += ++slot - time;
            }

            time = slot;
        }

        return exclusiveTime;
    }
}
// @lc code=end

