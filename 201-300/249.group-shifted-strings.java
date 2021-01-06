import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=249 lang=java
 *
 * [249] Group Shifted Strings
 */

// @lc code=start
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";

            for (char c : str.toCharArray()) {
                key += (char) ((c - 'a' - offset + 26) % 26);
            }

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(str);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> group : groups.values()) {
            res.add(group);
        }

        return res;
    }
}
// @lc code=end

