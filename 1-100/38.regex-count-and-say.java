import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        String ans = "1";

        String regex = "(.)\\1*";
        Pattern pattern = Pattern.compile(regex);

        while (n != 0) {
            String prev = ans;
            ans = new String();

            Matcher m = pattern.matcher(prev);
            while (m.find()) {
                ans += Integer.toString(m.group().length()) + m.group().charAt(0);
            }
        }

        return ans;
    }
}
// @lc code=end
