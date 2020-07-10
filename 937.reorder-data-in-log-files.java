import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode id=937 lang=java
 *
 * [937] Reorder Data in Log Files
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> cmp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                String[] split1 = s1.split(" ", 2);
                String[] split2 = s2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

                if (!isDigit1 && !isDigit2) {
                    int cmp = split1[1].compareTo(split2[1]);
                    if (cmp != 0) {
                        return cmp;
                    } else {
                        return split1[0].compareTo(split2[0]);
                    }
                } else {
                    return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
                }
            }
        };

        Arrays.sort(logs, cmp);

        return logs;
    }
}
// @lc code=end

