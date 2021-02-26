import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=761 lang=java
 *
 * [761] Special Binary String
 */

// @lc code=start
class Solution {
    public String makeLargestSpecial(String S) {
        List<String> largestSpecial = new ArrayList<>();
        for (int i = 0, anchor = 0, cnt = 0; i < S.length(); i++) {
            cnt += S.charAt(i) == '1' ? 1 : -1;

            if (cnt == 0) {
                largestSpecial.add('1' + makeLargestSpecial(S.substring(anchor + 1, i)) + '0');
                anchor = i + 1;
            }
        }

        Collections.sort(largestSpecial, Collections.reverseOrder());
        return String.join("", largestSpecial);
    }
}
// @lc code=end

