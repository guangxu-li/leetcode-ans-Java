import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
*/

// ! The logic of the solution is right, but since it's too slow, it exceeds time limit of leetcode

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // the smallest value of ans is 0
        // e.g empty string ""
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                Set<Character> set = new HashSet<>();
                boolean isRepeat = false;

                for (int k = i; k <= j; k++) {
                    if (set.contains(s.charAt(k))) {
                        isRepeat = true;
                        break;
                    } else {
                        set.add(s.charAt(k));
                    }
                }

                if (!isRepeat) {
                    ans = Math.max(ans, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}
// @lc code=end
