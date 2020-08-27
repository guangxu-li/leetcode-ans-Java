import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
class MedianFinder {
    private List<Integer> nums;
    private Random rand;

    private int quickselect(int n, int lo, int hi) {
        if (lo == hi) {
            return nums.get(lo);
        }

        int pivot = partition(lo, hi, lo + rand.nextInt(hi - lo));

        if (pivot < n) {
            return quickselect(n, pivot + 1, hi);
        } else if (pivot == n) {
            return nums.get(pivot);
        } else {
            return quickselect(n, lo, pivot - 1);
        }
    }

    private int partition(int lo, int hi, int pivot) {
        int pivotValue = nums.get(pivot);
        Collections.swap(nums, pivot, hi);

        int j = lo;
        for (int i = lo; i <= hi; i++) {
            if (nums.get(i) < pivotValue) {
                Collections.swap(nums, i, j++);
            }
        }

        Collections.swap(nums, j, hi);

        return j;
    }

    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList<>();
        rand = new Random();
    }

    public void addNum(int num) {
        nums.add(num);
    }

    public double findMedian() {
        int n = nums.size();

        return n % 2 == 1 ? quickselect(n / 2, 0, n - 1)
                : ((double) quickselect(n / 2 - 1, 0, n - 1) + quickselect(n / 2, 0, n - 1)) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
// @lc code=end

