import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=839 lang=java
 *
 * [839] Similar String Groups
 */

// @lc code=start
class Solution {
    private int[] visited;
    private List<List<Integer>> lists = new ArrayList<>();

    private void dfs(int i) {
        if (visited[i] == 1) {
            return;
        } else {
            visited[i] = 1;
        }

        for (int num : lists.get(i)) {
            dfs(num);
        }
    }

    private boolean isSimilar(char[] str1, char[] str2) {
        for (int i = 0, count = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) {
                count++;
            }

            if (count > 2) {
                return false;
            }
        }

        return true;
    }

    public int numSimilarGroups(String[] A) {
        visited = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                }

                if (isSimilar(A[i].toCharArray(), A[j].toCharArray())) {
                    list.add(j);
                }
            }

            lists.add(list);
        }

        int num = 0;
        for (int i = 0; i < lists.size(); i++) {
            if (visited[i] == 0) {
                num++;
                dfs(i);
            }
        }

        return num;
    }
}
// @lc code=end

