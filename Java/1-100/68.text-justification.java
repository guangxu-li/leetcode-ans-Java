import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> strs = new LinkedList<>();

        int hi = 0;
        while (hi < words.length) {
            int wordsCount = 0; /* exclude the first one */
            int wordsLen = words[hi].length();
            int minLen = wordsLen;

            int lo = hi++;
            while (hi < words.length && minLen + words[hi].length() + 1 <= maxWidth) {
                wordsCount++;
                wordsLen += words[hi].length();
                minLen += words[hi].length() + 1;
                hi++;
            }

            int spaceLen = maxWidth - wordsLen; /* total len of spaces */
            int spaceCount = wordsCount == 0 ? spaceLen
                    : spaceLen / wordsCount; /* len of spaces after each word */
            int extraSpace = wordsCount == 0 ? 0 : spaceLen % wordsCount;

            if (hi == words.length && wordsLen != maxWidth) {
                spaceCount = 1;
                extraSpace = 0;
            }
            int trailSpace = spaceLen;

            StringBuilder strBuilder = new StringBuilder();
            while (lo < hi) {
                strBuilder.append(words[lo]);

                if (wordsCount == 0 || lo != hi - 1) {
                    int n = extraSpace == 0 ? spaceCount : spaceCount + 1;
                    strBuilder.append(generateNSpaceString(n));

                    trailSpace -= n;
                }

                if (extraSpace != 0) {
                    extraSpace--;
                }
                lo++;
            }
            strBuilder.append(generateNSpaceString(trailSpace));

            strs.add(strBuilder.toString());
        }

        return strs;
    }

    private String generateNSpaceString(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        while (n != 0) {
            stringBuilder.append(" ");
            n--;
        }

        return stringBuilder.toString();
    }
}
// @lc code=end

