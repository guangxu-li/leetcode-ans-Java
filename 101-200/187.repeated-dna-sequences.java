import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=187 lang=java
 *
 * [187] Repeated DNA Sequences
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seqs = new HashSet<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String seq = s.substring(i, i + 10);
            if (visited.contains(seq)) {
                seqs.add(seq);
            } else {
                visited.add(seq);
            }
        }

        return new ArrayList<String>(seqs);
    }
}
// @lc code=end

