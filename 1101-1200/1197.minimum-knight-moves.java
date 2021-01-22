import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=1197 lang=java
 *
 * [1197] Minimum Knight Moves
 */

// @lc code=start
class Solution {
    private static final int[][] dirs =
            new int[][] {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    private int hash(int a, int b) {
        return (a + b) * (a + b + 1) / 2 + b;
    }

    private int[] getNext(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a <= b) {
            return new int[] {b, a};
        } else {
            return new int[] {a, b};
        }
    }

    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);

        if (x < y) {
            return minKnightMoves(y, x);
        }

        Queue<Integer> forward = new LinkedList<>();
        Queue<Integer> backward = new LinkedList<>();

        forward.add(0);
        forward.add(0);

        backward.add(x);
        backward.add(y);

        Set<Integer> fVisited = new HashSet<>();
        Set<Integer> bVisited = new HashSet<>();

        fVisited.add(hash(0, 0));
        bVisited.add(hash(x, y));

        int step = 0;
        while (!forward.isEmpty() && !backward.isEmpty()) {
            Queue<Integer> cur = forward.size() <= backward.size() ? forward : backward;
            Set<Integer> oppo = forward.size() <= backward.size() ? bVisited : fVisited;
            Set<Integer> visited = forward.size() <= backward.size() ? fVisited : bVisited;

            int size = cur.size() / 2;
            while (size-- > 0) {
                int a = cur.poll();
                int b = cur.poll();

                if (oppo.contains(hash(a, b))) {
                    return step;
                }

                for (int[] dir : dirs) {
                    int[] next = getNext(a + dir[0], b + dir[1]);

                    int hash = hash(next[0], next[1]);
                    if (!visited.contains(hash)) {
                        cur.add(next[0]);
                        cur.add(next[1]);
                        
                        visited.add(hash);
                    }
                }
            }

            step++;
        }

        return step;
    }
}
// @lc code=end


