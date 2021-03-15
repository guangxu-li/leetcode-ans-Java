/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class UnionFind {
    private int[] parents;
    public int cnt;

    public UnionFind(int n) {
        this.parents = new int[n];
        for (int i = 0; i < n; i++) {
            this.parents[i] = i;
        }
        cnt = n;
    }

    private int find(int i) {
        return i == parents[i] ? i : find(parents[i]);
    }

    public void union(int i, int j) {
        i = find(i);
        j = find(j);

        if (i != j) {
            cnt--;
            parents[j] = i;
        }
    }
}

class Solution {
    private int m;
    private int n;

    private int hash(int i, int j) {
        return i * n + j;
    }

    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    uf.cnt--;
                } else {
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        uf.union(hash(i, j), hash(i + 1, j));
                    }
                    
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        uf.union(hash(i, j), hash(i, j + 1));
                    }
                }
            }
        }

        return uf.cnt;
    }
}
// @lc code=end

