/*
 * @lc app=leetcode id=393 lang=java
 *
 * [393] UTF-8 Validation
 */

// @lc code=start
class Solution {
    private int getChar(int[] data, int i) {
        int cnt = 0;
        int d = data[i];
        for (int j = 0; j < 8; j++, cnt++) {
            if (((d << j) & 0x80) == 0) {
                break;
            }
        }

        return cnt;
    }

    public boolean validUtf8(int[] data) {
        int lo = 0;
        while (lo < data.length) {
            int len = getChar(data, lo);
            if (len == 1 || len > 4) {
                return false;
            }
            int hi = lo + (len == 0 ? 1 : len);
            
            if (!isValid(data, lo, hi)) {
                return false;
            }
            
            lo = hi;
        }

        return true;
    }

    private boolean isValid(int[] data, int lo, int hi) {
        if (hi > data.length) {
            return false;
        }

        for (int i = lo + 1; i < hi; i++) {
            if ((data[i] & 0x80) == 0 || (data[i] | 0x40) == 1) {
                return false;
            }
        }
        
        return true;
    }
}
// @lc code=end



