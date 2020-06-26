import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 */

// @lc code=start
class Solution {
    private List<String> ipAddresses = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, new int[4], 0, 0);

        return ipAddresses;
    }

    private void dfs(String s, int[] ipSections, int pos, int parsed) {
        if (pos == 4) {
            if (parsed == s.length()) {
                StringBuilder ip = new StringBuilder();
                while (pos > 0) {
                    ip.append(ipSections[4 - pos]);
                    if (pos > 1) {
                        ip.append('.');
                    }

                    pos--;
                }

                ipAddresses.add(ip.toString());
            }
        } else {
            int rem = s.length() - parsed;
            int lo = Math.max(1, rem - 3 * (3 - pos));
            int hi = Math.min(3, rem - (3 - pos));

            int curr = 0;
            for (int i = 1; i <= hi && (i == 1 || curr > 0) && curr <= 25; i++) {
                curr = curr * 10 + s.charAt(parsed + i - 1) - '0';

                if (i >= lo && curr <= 255) {
                    ipSections[pos] = curr;
                    dfs(s, ipSections, pos + 1, parsed + i);
                }
            }
        }
    }
}
// @lc code=end

