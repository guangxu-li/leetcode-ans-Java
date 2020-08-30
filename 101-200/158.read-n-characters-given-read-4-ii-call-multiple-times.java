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
    private int buffPtr = 0;
    private int buffCnt = 0;
    private char[] buffer = new char[4];

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (buffPtr == buffCnt) {
                buffCnt = read4(buffer);
                buffPtr = 0;

                if (buffCnt == 0) {
                    break;
                }
            }

            while (ptr < n && buffPtr < buffCnt) {
                buf[ptr++] = buffer[buffPtr++];
            }
        }

        return ptr;
    }
}
// @lc code=end

