/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String ans = "1";

        while (n > 1) {
            int i = 0;
            String prev = new String(ans);
            ans = new String();

            while (i < prev.length()) {

                int j = i + 1;
                while (j < prev.length()) {
                    if (prev.charAt(i) == prev.charAt(j)) {
                        j++;
                    } else {
                        break;
                    }

                }

                ans += Integer.toString(j - i) + prev.charAt(i);

                i = j;
            }

            n--;
        }

        return ans;
    }
}
// @lc code=end
