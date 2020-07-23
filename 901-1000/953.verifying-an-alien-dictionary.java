/*
 * @lc app=leetcode id=953 lang=java
 *
 * [953] Verifying an Alien Dictionary
 */

// @lc code=start
class Solution {
    private int[] orderDict = new int[26];

    private int compare(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int i = 0;
        while (i < s1.length && i < s2.length) {
            int order1 = orderDict[s1[i] - 'a'];
            int order2 = orderDict[s2[i] - 'a'];

            if (order1 < order2) {
                return -1;
            } else if (order1 > order2) {
                return 1;
            }

            i++;
        }

        if (i < s1.length) {
            return 1;
        } else if (i < s2.length) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            orderDict[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i]) == 1) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

