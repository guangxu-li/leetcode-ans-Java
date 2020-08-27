import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numCounter = new HashMap<>();
        Arrays.stream(nums)
                .forEach(num -> numCounter.put(num, numCounter.getOrDefault(num, 0) + 1));

        HashMap<Integer, ArrayList<Integer>> counter = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : numCounter.entrySet()) {
            if (!counter.containsKey(entry.getValue())) {
                counter.put(entry.getValue(), new ArrayList<>());
            }
            counter.get(entry.getValue()).add(entry.getKey());
        }


        int[] vals = new int[k];
        for (int i = nums.length; i >= 1 && k > 0; i--) {
            if (!counter.containsKey(i)) {
                continue;
            }

            ArrayList<Integer> list = counter.get(i);
            int size = list.size();
            while (size-- > 0 && k-- > 0) {
                vals[k] = list.get(size);
            }
        }

        return vals;
    }
}
// @lc code=end

