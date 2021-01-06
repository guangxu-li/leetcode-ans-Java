import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=251 lang=java
 *
 * [251] Flatten 2D Vector
 */

// @lc code=start
class Vector2D {
    private List<Integer> vals = new ArrayList<>();
    private int idx = 0;

    public Vector2D(int[][] v) {
        for (int[] nums : v) {
            for (int num : nums) {
                vals.add(num);
            }
        }
    }
    
    public int next() {
        return vals.get(idx++);
    }
    
    public boolean hasNext() {
        return idx != vals.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end

