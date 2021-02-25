import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=564 lang=java
 *
 * [564] Find the Closest Palindrome
 */

// @lc code=start
class Solution {
    private long getPalindrome(long left, boolean even) {
        long palindrome = left;
        if (!even)
            left /= 10;
        while (left > 0) {
            palindrome = palindrome * 10 + left % 10;
            left /= 10;
        }

        return palindrome;
    }

    public String nearestPalindromic(String n) {
        int len = n.length();
        int mid = len % 2 == 0 ? len / 2 : len / 2 + 1;
        long left = Long.parseLong(n.substring(0, mid));

        long val = Long.parseLong(n);
        Queue<Long> palindromes = new PriorityQueue<>(
                (a, b) -> Math.abs(a - val) == Math.abs(b - val) ? (a < b ? -1 : 1)
                        : (Math.abs(a - val) < Math.abs(b - val) ? -1 : 1));

        palindromes.add(getPalindrome(left, len % 2 == 0));
        palindromes.add(getPalindrome(left + 1, len % 2 == 0));
        palindromes.add(getPalindrome(left - 1, len % 2 == 0));
        palindromes.add((long) Math.pow(10, len - 1) - 1);
        palindromes.add((long) Math.pow(10, len) + 1);

        if (palindromes.peek() == val)
            palindromes.poll();

        return String.valueOf(palindromes.poll());
    }
}
// @lc code=end

