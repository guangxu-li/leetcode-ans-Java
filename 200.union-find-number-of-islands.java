/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    private char[][] grid;
    private int[] parent;
    private int num = 0;

    private int find(int i) {

        /* 
         * !!! 'if' won't work, it has to be 'while'
         * consider the input:
         * 
         * 1 1 1 1 1  1  1
         * 0 1 1 0 1  1  0
         * 1 1 0 1 1 _1_ 1
         * 
         * The wrong result happens at the grid[2][5] from the end
         * 
         */
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }

        return i;
    }

    private void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            parent[j] = i;
            num--;
        }
    }

    private void buildSets() {
        for (int i = 0, c = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                parent[i * grid[0].length + j] = c++;
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.grid = grid;
        this.parent = new int[grid.length * grid[0].length];

        buildSets();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    if (i < grid.length - 1 && grid[i + 1][j] == '1') {
                        union(i * grid[0].length + j, (i + 1) * grid[0].length + j);
                    }

                    if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
                        union(i * grid[0].length + j, i * grid[0].length + j + 1);
                    }
                }
            }
        }

        return num;
    }
}
// @lc code=end

