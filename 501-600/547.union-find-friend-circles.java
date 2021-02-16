/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    private int[] parent;
    private int cnt;

    private int find(int i) {
        return i == parent[i] ? i : find(parent[i]);
    }

    private void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            parent[i] = j;
            cnt--;
        }
    }

    public int findCircleNum(int[][] M) {
        parent = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            parent[i] = i;
        }
        this.cnt = M.length;

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return cnt;
    }
}
// @lc code=end

