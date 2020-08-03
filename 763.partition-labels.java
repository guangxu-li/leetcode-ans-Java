import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=763 lang=java
 *
 * [763] Partition Labels
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] s = S.toCharArray();

        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length; i++) {
            lastIndex[s[i] - 'a'] = i;
        }

        List<Integer> lens = new ArrayList<>();
        int rightMost = 0;
        int prev = 0;

        for (int i = 0; i < s.length; i++) {
            rightMost = Math.max(rightMost, lastIndex[s[i] - 'a']);

            if (i == rightMost) {
                lens.add(i + 1 - prev);
                prev = i + 1;
            }
        }

        return lens;
    }
}
// @lc code=end

