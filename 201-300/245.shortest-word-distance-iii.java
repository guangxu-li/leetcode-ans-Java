/*
 * @lc app=leetcode id=245 lang=java
 *
 * [245] Shortest Word Distance III
 */

// @lc code=start
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        long p1 = Integer.MIN_VALUE;
        long p2 = Integer.MAX_VALUE;
        long min = Integer.MAX_VALUE;

        boolean isEqual = word1.equals(word2);

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (isEqual) {
                    p1 = p2;
                    p2 = i;
                } else {
                    p1 = i;
                }
            } else if (words[i].equals(word2)) {
                p2 = i;
            }

            min = Math.min(min, Math.abs(p1 - p2));
        }

        return (int) min;
    }
}
// @lc code=end

