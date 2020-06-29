import java.math.BigInteger;

/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        while (y.compareTo(new BigInteger("0")) > 0) {
            BigInteger sum = x.xor(y);
            y = x.and(y).shiftLeft(1);
            x = sum;
        }

        return x.toString(2);
    }
}
// @lc code=end

