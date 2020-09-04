import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=609 lang=java
 *
 * [609] Find Duplicate File in System
 */

// @lc code=start
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> dupFiles = new HashMap<>();

        for (String path : paths) {

            // root/a 1.txt(abcd) 2.txt(efgh) -> root/a, 1.txt, abcd, 2.txt, efgh
            String[] files = path.split("\\(|\\) |\\)| ");
            for (int i = 1; i < files.length; i += 2) {
                dupFiles.putIfAbsent(files[i + 1], new ArrayList<>());
                dupFiles.get(files[i + 1]).add(files[0] + '/' + files[i]);
            }
        }

        return dupFiles.values().stream().filter(v -> v.size() > 1).collect(Collectors.toList());
    }
}
// @lc code=end

