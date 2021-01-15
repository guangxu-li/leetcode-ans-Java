import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 */

// @lc code=start
class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<Integer> ps = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    ps.add(i);
                    ps.add(j);
                }
            }
        }

        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!ps.isEmpty()) {
            int i = ps.poll();
            int j = ps.poll();

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni < 0 || ni == rooms.length || nj < 0 || nj == rooms[i].length
                        || rooms[ni][nj] != Integer.MAX_VALUE) {
                    continue;
                }

                rooms[ni][nj] = rooms[i][j] + 1;
                ps.add(ni);
                ps.add(nj);
            }
        }
    }
}
// @lc code=end

