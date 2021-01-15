import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start
class Solution {
    private List<String> operations = new ArrayList<>();
    private StringBuilder operation = new StringBuilder();
    private int target;
    private String num;

    private void helper(int pos, long val, long tmp) {
        if (pos == num.length()) {
            if (val == target) {
                operations.add(new String(operation.toString()));
            }
        } else {
            int len = operation.length();
            for (int i = pos; i < num.length(); i++) {
                if (i > pos && num.charAt(pos) == '0') {
                    break;
                }

                long cur = Long.parseLong(num.substring(pos, i + 1));

                if (pos == 0) {
                    operation.append(cur);
                    helper(i + 1, cur, cur);
                    operation.setLength(len);
                } else {
                    operation.append("+").append(cur);
                    helper(i + 1, val + cur, cur);
                    operation.setLength(len);

                    operation.append("-").append(cur);
                    helper(i + 1, val - cur, -cur);
                    operation.setLength(len);

                    operation.append("*").append(cur);
                    helper(i + 1, val - tmp + tmp * cur, tmp * cur);
                    operation.setLength(len);
                }
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        if (num == null || num.isEmpty()) {
            return operations;
        }

        this.target = target;
        this.num = num;

        helper(0, 0, 0);

        return operations;
    }
}
// @lc code=end

