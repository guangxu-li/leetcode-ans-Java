/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    private int[] parent;
    private int count;

    private int find(int i) {
        return parent[i] == i ? i : find(parent[i]);
    }

    private void union(int i, int j) {
        int x = find(i);
        int y = find(j);

        if (x != y) {
            parent[x] = y;
            count--;
        }
    }

    public int findCircleNum(int[][] M) {
        this.parent = new int[M.length];
        this.count = M.length;
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (i != j && M[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return count;
    }
}
// @lc code=end

