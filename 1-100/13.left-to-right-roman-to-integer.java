import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    static Map<Character, Integer> values = new HashMap<>();

    static {
        values.put('M', 1000);
        values.put('D', 500);
        values.put('C', 100);
        values.put('L', 50);
        values.put('X', 10);
        values.put('V', 5);
        values.put('I', 1);
    }

    public int romanToInt(String s) {
        int ans = 0;
        char[] sChars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int x = values.get(sChars[i]);
            int y = i == s.length() - 1 ? 0 : values.get(sChars[i + 1]);

            ans += x < y ? -x : x;
        }

        return ans;
    }
}
// @lc code=end
