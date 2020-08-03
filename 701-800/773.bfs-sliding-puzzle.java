import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=773 lang=java
 *
 * [773] Sliding Puzzle
 */

// @lc code=start
class Solution {
    private int hash(int[][] board) {
        int hash = 0;
        for (int[] row : board) {
            for (int cell : row) {
                hash = hash * 10 + cell;
            }
        }

        return hash;
    }

    private int bfs(int[][] board, int i, int j, int start) {
        Queue<Integer> hashs = new ArrayDeque<>();
        hashs.add(start);
        hashs.add(0);
        hashs.add(i);
        hashs.add(j);

        Set<Integer> visited = new HashSet<>();

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!hashs.isEmpty()) {
            int hash = hashs.poll();
            int step = hashs.poll();
            int curRow = hashs.poll();
            int curCol = hashs.poll();

            if (hash == 123450) {
                return step;
            }

            /* If reach this, it's impossible to have a solution.
               Please google sixteen puzzle problem for the proof */
            if (hash == 123540) {
                return -1;
            }

            if (visited.contains(hash)) {
                continue;
            }

            visited.add(hash);

            for (int[] dir : dirs) {
                int nextRow = curRow + dir[0];
                int nextCol = curCol + dir[1];

                if (nextRow < 0 || nextRow >= board.length || nextCol < 0
                        || nextCol >= board[0].length) {
                    continue;
                }

                hashs.add(reHash(hash, nextRow, nextCol, curRow, curCol));
                hashs.add(step + 1);
                hashs.add(nextRow);
                hashs.add(nextCol);
            }
        }
        return -1;
    }

    private int reHash(int hash, int m, int n, int i, int j) {
        int base0 = (int) Math.pow(10, 5 - i * 3 - j);
        int base1 = (int) Math.pow(10, 5 - m * 3 - n);

        int x = hash % (base1 * 10) / base1;

        return hash - x * base1 + x * base0;
    }

    public int slidingPuzzle(int[][] board) {
        int hash = hash(board);
        if (hash == 123450) {
            return 0;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    return bfs(board, i, j, hash);
                }
            }
        }

        return -1;
    }
}
// @lc code=end

