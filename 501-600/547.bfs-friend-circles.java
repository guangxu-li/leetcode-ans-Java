import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 */

// @lc code=start
class Solution {
    public int findCircleNum(int[][] M) {
        Queue<Integer> people = new ArrayDeque<>();
        boolean[] visited = new boolean[M.length];

        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                count++;

                people.add(i);
                while (!people.isEmpty()) {
                    int person = people.poll();
                    visited[person] = true;
                    for (int j = 0; j < M[0].length; j++) {
                        if (M[person][j] == 1 && !visited[j]) {
                            people.add(j);
                        }
                    }
                }
            }
        }

        return count;
    }
}
// @lc code=end

