import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int[] tCount = new int[256];

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i)]++;
        }

        List<Pair<Integer, Character>> st = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (tCount[s.charAt(i)] > 0) {
                st.add(new Pair<Integer, Character>(i, s.charAt(i)));
            }
        }

        // index of the minimum window / res windows
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE; // min size of ans window

        int formed = 0; // number of characters in t which has been included

        for (int lo = 0, hi = 0; hi < st.size(); hi++) {

            char c = st.get(hi).getValue();

            if (tCount[c]-- > 0) {
                formed++;
            }

            while (lo <= hi && formed == t.length()) {
                c = st.get(lo).getValue();
                if (st.get(hi).getKey() - st.get(lo).getKey() + 1 < min) {
                    end = st.get(hi).getKey() + 1;
                    start = st.get(lo).getKey();
                    min = end - start + 1;
                }

                if (tCount[c]++ == 0) {
                    formed--;
                }

                lo++;
            }
        }

        return s.substring(start, end);
    }
}
// @lc code=end
