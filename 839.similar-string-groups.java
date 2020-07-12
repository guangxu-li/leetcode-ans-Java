/*
 * @lc app=leetcode id=839 lang=java
 *
 * [839] Similar String Groups
 */

// @lc code=start
class Solution {
    private class UnionFind {
        int[] parent;
        int num;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            num = n;
        }

        public void union(int i, int j) {
            int root1 = find(i);
            int root2 = find(j);

            if (root1 != root2) {
                parent[root2] = root1;
                num--;
            }
        }

        public int find(int i) {
            return parent[i] == i ? i : find(parent[i]);
        }
    }

    private boolean isSimilar(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i) && count++ == 2) {
                return false;
            }
        }

        return true;
    }

    public int numSimilarGroups(String[] A) {
        UnionFind uFind = new UnionFind(A.length);

        for (int i = 0; i < A.length - 1 && uFind.num > 1; i++) {
            for (int j = i + 1; j < A.length && uFind.num > 1; j++) {
                if (isSimilar(A[i], A[j])) {
                    uFind.union(i, j);
                }
            }
        }

        return uFind.num;
    }
}
// @lc code=end

