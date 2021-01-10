import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=271 lang=java
 *
 * [271] Encode and Decode Strings
 */

// @lc code=start
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return String.valueOf((char) 258);
        }

        String splitter = String.valueOf((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
            sb.append(splitter);
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s.equals(String.valueOf((char) 258))) {
            return new ArrayList<>();
        }

        return Arrays.asList(s.split(String.valueOf((char) 257), -1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
// @lc code=end

