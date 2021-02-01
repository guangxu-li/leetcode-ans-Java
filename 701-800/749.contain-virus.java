import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=749 lang=java
 *
 * [749] Contain Virus
 */

// @lc code=start
class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int[][] grid;
    private int m = 0;
    private int n = 0;

    private int dfs(Set<Integer> seen, Set<Integer> island, Set<Integer> frontier, int i, int j) {
        int curHash = i * n + j;
        if (seen.contains(curHash)) {
            return 0;
        }
        seen.add(curHash);
        island.add(curHash);

        int perimeter = 0;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            int nHash = ni * n + nj;

            if (ni < 0 || ni == m || nj < 0 || nj == n) {
                continue;
            }

            if (grid[ni][nj] == 0) {
                frontier.add(nHash);
                perimeter++;
            } else if (grid[ni][nj] == 1) { // -1 -> already contained
                perimeter += dfs(seen, island, frontier, ni, nj);
            }
        }

        return perimeter;
    }

    public int containVirus(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        int numOfWall = 0;

        while (true) {
            Set<Integer> seen = new HashSet<>();
            List<Set<Integer>> islands = new ArrayList<>();
            List<Set<Integer>> frontiers = new ArrayList<>();
            List<Integer> perimeters = new ArrayList<>();

            int max = -1;
            int anchor = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !seen.contains(i * n + j)) {
                        Set<Integer> island = new HashSet<>();
                        Set<Integer> frontier = new HashSet<>();

                        islands.add(island);
                        frontiers.add(frontier);

                        perimeters.add(dfs(seen, island, frontier, i, j));

                        if (frontier.size() > max) {
                            max = frontier.size();
                            anchor = frontiers.size() - 1;
                        }
                    }
                }
            }

            if (islands.isEmpty()) {
                break;
            }

            numOfWall += perimeters.get(anchor);
            for (int i = 0; i < islands.size(); i++) {
                if (i == anchor) {
                    for (int hash : islands.get(i)) {
                        int pi = hash / n;
                        int pj = hash % n;

                        grid[pi][pj] = -1; // -1 == contained
                    }
                } else {
                    for (int hash : frontiers.get(i)) {
                        int pi = hash / n;
                        int pj = hash % n;

                        grid[pi][pj] = 1; // spread
                    }
                }
            }
        }

        return numOfWall;
    }
}
// @lc code=end

