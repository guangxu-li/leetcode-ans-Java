/*
 * @lc app=leetcode id=158 lang=java
 *
 * [158] Read N Characters Given Read4 II - Call multiple times
 */

// @lc code=start
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    private char[] buf4 = new char[4];
    private int count = 0;
    private int buf4Idx = 0;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int wrote = 0;
        while (wrote < n) {
            if (buf4Idx == count) {
                count = read4(buf4);
                buf4Idx = 0;
            }

            if (count == 0) {
                break;
            }

            while (wrote < n && buf4Idx < count) {
                buf[wrote++] = buf4[buf4Idx++];
            }
        }

        return wrote;
    }
}
// @lc code=end

