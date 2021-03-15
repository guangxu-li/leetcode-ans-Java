import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode id=1424 lang=java
 *
 * [1424] Diagonal Traverse II
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<LinkedList<Integer>> layers = new ArrayList<>();
        int cnt = 0;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> vals = nums.get(i);
            for (int j = 0; j < vals.size(); j++, cnt++) {
                int layer = i + j;
                if (layer == layers.size()) {
                    layers.add(new LinkedList<>());
                }

                layers.get(layer).addFirst(vals.get(j));
            }
        }

        int[] output = new int[cnt];
        int i = 0;
        for (LinkedList<Integer> layer : layers) {
            for (int num : layer) {
                output[i++] = num;
            }
        }

        return output;
    }
}
// @lc code=end

