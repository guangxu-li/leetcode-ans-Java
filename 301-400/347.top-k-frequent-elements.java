import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    private Map<Integer, Integer> counter = new HashMap<>();
    private Random rand = new Random();

    private void quickselect(int[] vals, int lo, int hi, int k) {
        if (lo == hi) {
            return;
        }

        int pivot = partition(vals, lo, hi, rand.nextInt(hi - lo) + lo);

        if (pivot == k) {
            return;
        } else if (pivot < k) {
            quickselect(vals, pivot + 1, hi, k);
        } else {
            quickselect(vals, lo, pivot - 1, k);
        }
    }

    private int partition(int[] vals, int lo, int hi, int pivot) {
        int pivotValue = counter.get(vals[pivot]);

        swap(vals, pivot, hi);
        int j = lo;
        for (int i = lo; i <= hi; i++) {
            if (counter.get(vals[i]) > pivotValue) {
                swap(vals, i, j++);
            }
        }
        swap(vals, j, hi);

        return j;
    }

    private void swap(int[] vals, int i, int j) {
        int tmp = vals[i];
        vals[i] = vals[j];
        vals[j] = tmp;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Arrays.stream(nums).forEach(num -> counter.put(num, counter.getOrDefault(num, 0) + 1));

        int[] vals = new int[counter.size()];
        int index = 0;
        for (int num : counter.keySet()) {
            vals[index++] = num;
        }

        quickselect(vals, 0, vals.length - 1, k - 1);
        return Arrays.copyOfRange(vals, 0, k);
    }
}
// @lc code=end

