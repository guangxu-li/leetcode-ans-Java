import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=271 lang=java
 *
 * [271] Encode and Decode Strings
 */

// @lc code=start
public class Codec {
    private String encodeLen(int len) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            sb.append((char) (len & 0xFF));
            len >>= 8;
        }

        return sb.toString();
    }

    private int decodeLen(String s, int lo, int hi) {
        int len = 0;

        for (int i = hi - 1; i >= lo; i--) {
            len += (int) s.charAt(i);

            if (i > lo) {
                len <<= 8;
            }
        }

        return len;
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(encodeLen(str.length()));
            sb.append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int len = decodeLen(s, i, i + 4);
            i += 4;

            strs.add(s.substring(i, i + len));
            i += len;
        }

        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
// @lc code=end

