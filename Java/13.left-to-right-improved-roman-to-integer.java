import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("I", 1);
        values.put("V", 5);
        values.put("X", 10);
        values.put("L", 50);
        values.put("C", 100);
        values.put("D", 500);
        values.put("M", 1000);
        values.put("IV", 4);
        values.put("IX", 9);
        values.put("XL", 40);
        values.put("XC", 90);
        values.put("CD", 400);
        values.put("CM", 900);
    }

    public int romanToInt(String s) {
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (i != s.length() - 1 && values.containsKey(s.substring(i, i + 2))) {
                ans += values.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += values.get(s.substring(i, i + 1));
                i += 1;
            }
        }

        return ans;
    }
}
// @lc code=end
