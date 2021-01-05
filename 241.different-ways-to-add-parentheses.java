import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    private List<Integer> compute(char[] input, int lo, int hi) {
        List<Integer> res = new ArrayList<>();

        for (int i = lo; i <= hi; i++) {
            if (input[i] == '+' || input[i] == '-' || input[i] == '*') {
                for (int left : compute(input, lo, i - 1)) {
                    for (int right : compute(input, i + 1, hi)) {
                        switch (input[i]) {
                            case '+':
                                res.add(left + right);
                                break;
                            case '-':
                                res.add(left - right);
                                break;
                            case '*':
                                res.add(left * right);
                                break;
                        }
                    }
                }
            }
        }

        if (res.isEmpty()) {
            res.add(Integer.valueOf(new String(input, lo, hi - lo + 1)));
        }

        return res;
    }

    public List<Integer> diffWaysToCompute(String input) {
        return compute(input.toCharArray(), 0, input.length() - 1);
    }
}
// @lc code=end

