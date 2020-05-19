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
        int required = 0; // unique characters in t. abbc -> 3

        for (int i = 0; i < t.length(); i++) {
            if (tCount[t.charAt(i)] == 0) {
                required++;
            }
            tCount[t.charAt(i)]++;
        }

        List<Pair<Integer, Character>> st = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (tCount[s.charAt(i)] > 0) {
                st.add(new Pair<Integer, Character>(i, s.charAt(i)));
            }
        }

        // index of the window
        int lo = 0;
        int hi = 0;

        // index of the minimum window / res windows
        int start = 0;
        int end = 0;
        int min = -1; // min size of ans window

        int[] window = new int[256];
        int formed = 0; // unique characters in t which has been included in s

        while (hi < st.size()) {
            char c = st.get(hi).getValue();
            window[c]++;

            if (window[c] == tCount[c]) {
                formed++;
            }

            while (lo <= hi && formed == required) {
                if (min == -1 || st.get(hi).getKey() - st.get(lo).getKey() + 1 < min) {
                    end = st.get(hi).getKey();
                    start = st.get(lo).getKey();
                    min = end - start + 1;

                }

                c = st.get(lo).getValue();
                window[c]--;

                if (window[c] < tCount[c]) {
                    formed--;
                }

                lo++;
            }

            hi++;
        }

        return min == -1 ? "" : s.substring(start, end + 1);
    }
}
// @lc code=end
