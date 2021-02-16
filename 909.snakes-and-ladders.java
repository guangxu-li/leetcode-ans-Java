import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=909 lang=java
 *
 * [909] Snakes and Ladders
 */

// @lc code=start
class Solution {
    private int[] parseIdx(int pos, int n) {
        pos--;
        int rShift = pos / n;
        int x = n - 1 - rShift;
        int cShift = pos % n;

        int y = 0;
        if (rShift % 2 == 0) {
            y = cShift;
        } else {
            y = n - 1 - cShift;
        }

        return new int[] {x, y};
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> cells = new LinkedList<>();
        cells.add(1);

        int move = 0;
        while (!cells.isEmpty()) {
            int size = cells.size();
            while (size-- > 0) {
                int cur = cells.poll();
                if (cur == n * n) {
                    return move;
                }

                if (visited[cur]) {
                    continue;
                }
                visited[cur] = true;

                for (int next = cur + 1; next <= Math.min(n * n, cur + 6); next++) {
                    int[] idx = parseIdx(next, n);
                    int x = idx[0];
                    int y = idx[1];
                    if (board[x][y] > 0) {
                        cells.add(board[x][y]);
                    } else {
                        cells.add(next);
                    }
                }
            }

            move++;
        }

        return -1;
    }
}


