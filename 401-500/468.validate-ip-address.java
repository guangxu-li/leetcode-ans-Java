/*
 * @lc app=leetcode id=468 lang=java
 *
 * [468] Validate IP Address
 */

// @lc code=start
class Solution {
    private String checkIPv4(String IP) {
        String[] sxns = IP.split("\\.");
        int n = sxns.length;
        if (n != 4 || IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') {
            return "Neither";
        }

        for (String sxn : sxns) {
            if (sxn.length() > 3) {
                return "Neither";
            }

            int num = 0;
            try {
                num = Integer.parseInt(sxn);
            } catch (NumberFormatException nfe) {
                return "Neither";
            }

            if (num > 255) {
                return "Neither";
            }

            if (num == 0 && sxn.length() > 1) {
                return "Neither";
            }

            if (num > 0 && sxn.charAt(0) == '0') {
                return "Neither";
            }
        }

        return "IPv4";
    }

    private String checkIPv6(String IP) {
        String[] sxns = IP.split("\\:");
        int n = sxns.length;
        if (n != 8 || IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') {
            return "Neither";
        }

        for (String sxn :  sxns) {
            if (sxn.length() > 4) {
                return "Neither";
            }

            int num = 0;
            try {
                num = Integer.parseInt(sxn, 16);
            } catch (NumberFormatException nfe) {
                return "Neither";
            }

            if (num > 0xFFFF) {
                return "Neither";
            }
        }

        return "IPv6";
    }

    public String validIPAddress(String IP) {
        return IP.indexOf(".") > -1 ? checkIPv4(IP) : checkIPv6(IP);
    }
}
// @lc code=end


