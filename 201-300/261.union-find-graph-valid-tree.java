/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class UnionFind {
    private int[] parents;

    public UnionFind(int n) {
        parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int A) {
        return A == parents[A] ? A : find(parents[A]);
    }

    public boolean union(int A, int B) {
        int rootA = find(A);
        int rootB = find(B);

        if (rootA == rootB) {
            return true;
        }

        parents[rootA] = rootB;

        return false;
    }
}


class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

