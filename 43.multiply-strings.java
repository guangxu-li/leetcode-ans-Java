/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {

        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int curr = i + j + 1;
                int next = i + j;

                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[curr];

                result[curr] = num % 10;
                result[next] += num / 10;

            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i : result) {
            if (ans.length() == 0 && i == 0) {
                continue;
            } else {
                ans.append(i);
            }
        }

        return ans.length() == 0 ? "0" : ans.toString();
    }
}
// @lc code=end

