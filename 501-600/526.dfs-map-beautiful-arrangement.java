import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode id=526 lang=java
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    private int arrange(Set<Integer> used, int n) {
        String code = used.toString();
        if (memo.containsKey(code)) {
            return memo.get(code);
        }

        int pos = used.size() + 1;
        int cnt = 0;

        if (pos > n) {
            cnt = 1;
        } else {
            for (int i = 1; i <= n; i++) {
                if (used.contains(i)) {
                    continue;
                }

                if (i % pos == 0 || pos % i == 0) {
                    used.add(i);
                    cnt += arrange(used, n);
                    used.remove(i);
                }
            }
        }

        memo.put(code, cnt);
        return cnt;
    }

    public int countArrangement(int n) {
        return arrange(new HashSet<>(), n);
    }
}
// @lc code=end
