import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    private Map<Integer, String> dict = new HashMap<>() {
        {
            put(3, "Fizz");
            put(5, "Buzz");
        }
    };

    public List<String> fizzBuzz(int n) {
        List<String> nums = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int key : dict.keySet()) {
                if (i % key == 0) {
                    sb.append(dict.get(key));
                }
            }

            if (sb.length() == 0) {
                sb.append(i);
            }

            nums.add(sb.toString());
        }

        return nums;
    }
}
