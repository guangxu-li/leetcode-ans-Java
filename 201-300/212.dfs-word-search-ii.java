import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
    private char[][] board;

    private boolean contains(char[] word) {
        if (word.length == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char prev = board[i][j];
                if (prev == word[0]) {
                    if (dfs(word, i, j, 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[] word, int row, int col, int pos) {
        if (pos == word.length) {
            return true;
        } else {
            char prev = board[row][col];
            board[row][col] = '.';

            int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] dir : dirs) {
                int i = row + dir[0];
                int j = col + dir[1];

                if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
                    continue;
                }

                if (board[i][j] == word[pos] && dfs(word, i, j, pos + 1)) {
                    board[row][col] = prev;
                    return true;
                }
            }

            board[row][col] = prev;
            return false;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ws = new ArrayList<>();

        if (board.length == 0 || board[0].length == 0) {
            return ws;
        }

        this.board = board;

        for (String word : words) {
            if (contains(word.toCharArray())) {
                System.out.println(word);
                ws.add(word);
            }
        }

        return ws;
    }
}
// @lc code=end

