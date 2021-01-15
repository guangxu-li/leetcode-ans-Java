import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=281 lang=java
 *
 * [281] Zigzag Iterator
 */

// @lc code=start
public class ZigzagIterator {
    private List<List<Integer>> lists = new ArrayList<>();
    private Queue<Integer> ps = new ArrayDeque<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        lists.add(v1);
        lists.add(v2);

        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                ps.add(i);
                ps.add(0);
            }
        }
    }

    public int next() {
        int l = ps.poll();
        int e = ps.poll();

        if (e < lists.get(l).size() - 1) {
            ps.add(l);
            ps.add(e + 1);
        }

        return lists.get(l).get(e);
    }

    public boolean hasNext() {
        return !ps.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
// @lc code=end

