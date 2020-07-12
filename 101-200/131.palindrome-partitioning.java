import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    private char[] str;
    private List<List<String>> partitions = new ArrayList<List<String>>();
    private List<String> partition = new ArrayList<String>();

    private Integer[][] isPalindrome;

    private void dfs(int start, int end) {
        if (start > end) {
            partitions.add(new ArrayList<String>(partition));
        } else {
            for (int i = start; i <= end; i++) {
                if (isPalindrome(start, i)) {
                    partition.add(toString(start, i));
                    dfs(i + 1, end);
                    partition.remove(partition.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(int i, int j) {
        if (isPalindrome[i][j] != null) {
            return isPalindrome[i][j] == 1;
        }

        boolean res = true;
        for (int m = i, n = j; m <= n; m++, n--) {
            if (str[m] != str[n]) {
                res = false;
                break;
            }
        }

        isPalindrome[i][j] = res ? 1 : 0;
        return res;
    }

    private String toString(int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = start; i <= end; i++) {
            stringBuilder.append(str[i]);
        }

        return stringBuilder.toString();
    }

    public List<List<String>> partition(String s) {
        this.str = s.toCharArray();
        this.isPalindrome = new Integer[s.length()][s.length()];

        dfs(0, s.length() - 1);

        return partitions;
    }
}
// @lc code=end

