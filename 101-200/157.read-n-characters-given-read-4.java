/*
 * @lc app=leetcode id=157 lang=java
 *
 * [157] Read N Characters Given Read4
 */

// @lc code=start
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buf4 = new char[4];
        int idx = 0;

        int count = 0;
        do {
            count = read4(buf4);

            for (int i = 0; i < count && idx < n; i++, idx++) {
                buf[idx] = buf4[i];
            }
        } while (count != 0 && idx < n);

        return idx;
    }
}
// @lc code=end

