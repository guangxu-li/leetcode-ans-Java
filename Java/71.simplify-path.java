import java.util.Stack;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }

        Stack<String> dirs = new Stack<>();
        StringBuilder canonicalPath = new StringBuilder();

        String[] pathSplices = path.split("/");
        for (String pathSplice : pathSplices) {
            if (pathSplice.equals("..")) {
                if (!dirs.isEmpty()) {
                    dirs.pop();
                }
            } else if (!pathSplice.isEmpty() && !pathSplice.equals(".")) {
                dirs.push(pathSplice);
            }
        }

        for (String dir : dirs) {
            canonicalPath.append("/");
            canonicalPath.append(dir);
        }

        return dirs.isEmpty() ? "/" : canonicalPath.toString();
    }
}
// @lc code=end

