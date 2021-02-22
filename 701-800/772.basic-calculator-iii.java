import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode id=772 lang=java
 *
 * [772] Basic Calculator III
 */

// @lc code=start
class Solution {
    private int priority(char c) {
        switch (c) {
            case '+', '-':
                return 1;
            case '*', '/':
                return 2;
            case '!':
                return 3;
            default:
                return 0;
        }
    }

    private List<String> postfix(String str) {
        List<String> post = new ArrayList<>();
        Deque<Character> ops = new ArrayDeque<>();

        int i = 0;
        char prev = '+';
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }

            if (Character.isDigit(c)) {
                int num = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + str.charAt(i) - '0';
                    i++;
                }
                post.add(String.valueOf(num));
            } else if (c == '(') {
                ops.push(c);
                i++;
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    post.add(String.valueOf(ops.pop()));
                }

                ops.pop();
                i++;
            } else if (priority(prev) > 0) {
                ops.push('!');
                i++;
            } else {
                while (!ops.isEmpty() && priority(ops.peek()) >= priority(c)) {
                    post.add(String.valueOf(ops.pop()));
                }
                ops.push(c);
                i++;
            }

            prev = c;
        }

        while (!ops.isEmpty()) {
            post.add(String.valueOf(ops.pop()));
        }

        return post;
    }

    private int cal(int op1, int op2, char op) {
        switch (op) {
            case '+':
                return op1 + op2;
            case '-':
                return op2 - op1;
            case '*':
                return op1 * op2;
            case '/':
                return op2 / op1;
            default:
                return -1;
        }
    }

    private boolean isOps(String str) {
        return str.length() == 1 && !Character.isDigit(str.charAt(0));
    }

    public int calculate(String s) {
        List<String> expression = postfix(s);
        Deque<Integer> res = new ArrayDeque<>();

        for (String str : expression) {
            if (isOps(str)) {
                res.push(str.equals("!") ? -res.pop() : cal(res.pop(), res.pop(), str.charAt(0)));
            } else {
                res.push(Integer.parseInt(str));
            }
        }

        return res.peek();
    }
}
// @lc code=end


