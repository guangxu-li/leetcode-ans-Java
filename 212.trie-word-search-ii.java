import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String word = null;
    public int numOfChild = 0;
}


class Solution {
    List<String> ws = new ArrayList<>();
    private char[][] board;

    private void dfs(int row, int col, TrieNode root) {
        char c = board[row][col];
        TrieNode curNode = root.children[c - 'a'];

        if (curNode.word != null) {
            ws.add(curNode.word);
            curNode.word = null;
        }

        board[row][col] = '.';

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int i = row + dir[0];
            int j = col + dir[1];

            if (i < 0 || j < 0 || i == board.length || j == board[0].length || board[i][j] == '.') {
                continue;
            }

            if (curNode.children[board[i][j] - 'a'] != null) {
                dfs(i, j, curNode);
            }
        }

        board[row][col] = c;

        /* Prevernt from searching for a word that has been searched before */
        if (curNode.numOfChild == 0) {
            root.children[c - 'a'] = null;
            root.numOfChild--;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) {
            return ws;
        }

        this.board = board;

        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }

                node.numOfChild++;
                node = node.children[c - 'a'];
            }

            node.word = word;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    dfs(i, j, root);
                }
            }
        }

        return ws;
    }
}
// @lc code=end

