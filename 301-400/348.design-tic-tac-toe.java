/*
 * @lc app=leetcode id=348 lang=java
 *
 * [348] Design Tic-Tac-Toe
 */

// @lc code=start
class TicTacToe {
    private int[][] players;
    private int n;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        players = new int[2][2 * n + 2];
        isEnd = false;
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (isEnd) {
            return 0;
        }

        if (++players[player - 1][row] == n) {
            isEnd = true;
            return player;
        }

        if (++players[player - 1][n + col] == n) {
            isEnd = true;
            return player;
        }

        if (row == col && ++players[player - 1][2 * n] == n) {
            isEnd = true;
            return player;
        }

        if (row + col == n - 1 && ++players[player - 1][2 * n + 1] == n) {
            isEnd = true;
            return player;
        }

        return 0;
    }
}


/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
// @lc code=end

