/*
 * @lc app=leetcode id=427 lang=java
 *
 * [427] Construct Quad Tree
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    private int[][] grid;

    private boolean isLeaf(int rstart, int rend, int cstart, int cend) {
        int anchor = grid[rstart][cstart];

        for (int i = rstart; i <= rend; i++) {
            for (int j = cstart; j <= cend; j++) {
                if (grid[i][j] != anchor) {
                    return false;
                }
            }
        }

        return true;
    }

    private Node construct(int rstart, int rend, int cstart, int cend) {
        Node node = new Node(grid[rstart][cstart] == 1, false);

        if (isLeaf(rstart, rend, cstart, cend)) {
            node.isLeaf = true;

            return node;
        }

        int r = (rstart + rend) / 2;
        int c = (cstart + cend) / 2;

        node.topLeft = construct(rstart, r, cstart, c);
        node.topRight = construct(rstart, r, c + 1, cend);
        node.bottomLeft = construct(r + 1, rend, cstart, c);
        node.bottomRight = construct(r + 1, rend, c + 1, cend);        

        return node;
    }

    public Node construct(int[][] grid) {
        this.grid = grid;
        
        return construct(0, grid.length - 1, 0, grid.length - 1);
    }
}
// @lc code=end

