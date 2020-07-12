import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
    private char[][] board;
    private int rows;
    private int cols;
    private boolean[][] visited;

    private void bfs(int i, int j) {
        Queue<Integer> indices = new LinkedList<>();
        indices.add(i);
        indices.add(j);

        while (!indices.isEmpty()) {
            i = indices.poll();
            j = indices.poll();

            if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] == 'X' || visited[i][j]) {
                continue;
            }

            visited[i][j] = true;
            indices.add(i + 1);
            indices.add(j);

            indices.add(i - 1);
            indices.add(j);

            indices.add(i);
            indices.add(j + 1);

            indices.add(i);
            indices.add(j - 1);
        }
    }

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            bfs(i, 0);
            bfs(i, cols - 1);
        }

        for (int i = 0; i < cols; i++) {
            bfs(0, i);
            bfs(rows - 1, i);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
// @lc code=end

