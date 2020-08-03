import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] s = S.toCharArray();

        int[] count = new int[26];
        for (char c : s) {
            count[c - 'a']++;
        }

        List<Integer> lens = new ArrayList<>();
        Set<Character> cs = new HashSet<>();
        int counter = 0;
        int prev = 0;

        for (int i = 0; i < s.length; i++) {
            char c = s[i];

            if (!cs.contains(c)) {
                counter += count[c - 'a'];
                cs.add(c);
            }
            counter--;

            if (counter == 0) {
                lens.add(i + 1 - prev);
                prev = i + 1;
            }
        }

        return lens;
    }
}
// @lc code=end

